package com.coskun;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
