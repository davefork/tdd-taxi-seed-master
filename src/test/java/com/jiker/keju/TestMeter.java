package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestMeter {

    @Test
    public void testMeter(){
        String testDataFile = "src/main/resources/testData.txt";
        String meterString= null;
        try {
            meterString = Calculator.meter(testDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("收费6元\n" +
                "收费7元\n" +
                "收费13元\n" +
                "收费7元",meterString);
    }
}
