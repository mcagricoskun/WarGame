package com.coskun;

import java.util.Random;

public class RandomNumberGenerator {
    private Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int generateRandomNumber(int maxValue) {
        return random.nextInt(maxValue) + 1;
    }
}
