package com.coskun.methods;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner input;

    private ScannerSingleton() {
        // Yalnızca bu sınıf içerisinde örnek oluşturulmasını engeller
    }

    public static Scanner getInput() {
        if (input == null) {
            input = new Scanner(System.in);
        }
        return input;
    }
}
