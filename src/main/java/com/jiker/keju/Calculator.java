package com.jiker.keju;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calculator {
    public static String meter(String testDataFile) throws IOException {
        BufferedReader meterReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(testDataFile)), StandardCharsets.UTF_8));
        String meterString = null;
        StringBuffer receipt = new StringBuffer();
        while ((meterString = meterReader.readLine()) != null) {
            receipt.append("收费").append(calucatePrice(meterString)).append("元\n");
        }
        meterReader.close();
        return receipt.toString();
    }

    private static String calucatePrice(String meterString) {
        Pattern pattern = Pattern.compile("[^0-9]+");
        String[] cs = pattern.split(meterString);
        StringBuilder sb = new StringBuilder();
        double price = 6;
        price = judgeDistanceIfBiggerThanNum(Integer.parseInt(cs[0]), price);
        price += 0.25 * Integer.parseInt(cs[1]);
        return String.valueOf(Math.round(price));
    }

    private static double judgeDistanceIfBiggerThanNum(int distance, double price) {
        if(distance > 8) {
            price += 1.2 * (distance - 8);
            distance = 8;
        }

        if(distance > 2) {
            price += 0.8 * (distance - 2);
        }
        return price;
    }

}
