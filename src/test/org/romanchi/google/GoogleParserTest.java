package org.romanchi.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GoogleParserTest {
    GoogleParser parser;
    @Before
    public void before(){
        parser = new GoogleParser();
    }

    @Test
    public void testNotFirstPage() throws Exception {
        GoogleResultItem googleResultItem = parser.find("євровікна", "львів");
        System.out.println("RESULT: " + googleResultItem);

    }
    @Test
    public void testFirstPage() {
        GoogleResultItem googleResultItem2 = parser.find("євровікна","Perfect");
        System.out.println("RESULT: " + googleResultItem2);
    }
    @After
    public void after(){
        try {
            parser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}