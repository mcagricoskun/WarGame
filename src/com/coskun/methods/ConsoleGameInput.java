package com.coskun.methods;

import java.util.Scanner;

public class ConsoleGameInput implements GameInput {
    private final Scanner scanner;

    public ConsoleGameInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
    @Override
    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }
}
