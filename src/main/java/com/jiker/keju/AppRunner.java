package com.jiker.keju;


import java.io.IOException;

import static com.jiker.keju.Calculator.meter;

public class AppRunner {
    public static void main(String[] args) {
        String testDataFile = args[0];
        String receipt = null;
        try {
            receipt = meter(testDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(receipt);
    }
}
