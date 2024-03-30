package com.coskun.printer;

import com.coskun.Player;
import com.coskun.hero.Hero;
import com.coskun.inventory.Inventory;
import com.coskun.monster.Monster;

import java.io.IOException;

public class EmailPrinter implements Printer{
    @Override
    public void printInventory(Inventory inventory) throws IOException {

    }

    @Override
    public void printWarStats(Monster m, Player p) {

    }

    @Override
    public void printHeroes(Hero[] heroes) throws IOException {

    }

    @Override
    public void printMenu() throws IOException {

    }

    @Override
    public void printMessage(String message) throws IOException {
    }
}
