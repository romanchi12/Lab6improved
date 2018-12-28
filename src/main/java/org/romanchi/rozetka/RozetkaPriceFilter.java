package org.romanchi.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RozetkaPriceFilter {
    WebElement filterElement;

    public RozetkaPriceFilter(WebElement filterElement) {
        this.filterElement = filterElement;
    }

    public void setMinPrice(int minPrice){
        WebElement minElement = filterElement.findElement(By.id("price[min]"));
        minElement.clear();
        minElement.sendKeys(String.valueOf(minPrice));
    }

    public void submit(){
        WebElement submitButtonElement =  filterElement.findElement(By.id("submitprice"));
        submitButtonElement.submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
