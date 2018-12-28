package org.romanchi.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RozetkaParser implements Closeable {
    private WebDriver driver;
    public RozetkaParser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.ByCssSelector.cssSelector("#sort_price .price-input")));

    }

    public RozetkaPriceFilter getPriceFilter(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.ByCssSelector.cssSelector("#sort_price .price-input")));
        return new RozetkaPriceFilter(driver.findElement(
                By.ByCssSelector.cssSelector("#sort_price .price-input")));
    }

    public List<RozetkaGoodTile> getFirstSetGoods(){
        List<WebElement> tiles = driver.
                findElements(By.ByCssSelector.cssSelector("[data-view_type=catalog_with_hover]"));
        List<RozetkaGoodTile> result = new ArrayList<>();
        for(WebElement tile:tiles){
            String goodName = tile.findElement(By.className("g-i-tile-i-title")).getText();
            String priceRaw = tile.findElement(By.className("g-price-uah")).getText();
            int price = Integer.valueOf(priceRaw
                    .substring(0,priceRaw.length()-3)
                    .replace("\u2009","")
                    .replace(" ",""));
            result.add(new RozetkaGoodTile(goodName,price));
        }

        return result;
    }


    @Override
    public void close() throws IOException {
        driver.close();
    }
}
