package org.romanchi.rozetka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RozetkaParserTest {
    RozetkaParser parser;
    @Before
    public void setUp() throws Exception {
        parser = new RozetkaParser();
    }

    @After
    public void tearDown() throws Exception {
        parser.close();
    }
    @Test
    public void testFilter(){
        int minPrice = 20000;
        RozetkaPriceFilter priceFilter = parser.getPriceFilter();
        priceFilter.setMinPrice(minPrice);
        priceFilter.submit();
        RozetkaGoodTile toCompare = new RozetkaGoodTile("MinPricedGood", minPrice);
        for(RozetkaGoodTile tile:parser.getFirstSetGoods()){
            if(tile.compareTo(toCompare) < 0){
                fail("Bad filter");
            }
        }
    }
}