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
        System.out.println(meterString);
        String trueResult="price 6 yuan\n"  +"price 7 yuan\n" + "price 13 yuan\n" + "price 7 yuan\n";
        Assert.assertEquals(trueResult,meterString);
    }
}
