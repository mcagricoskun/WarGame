package com.coskun.printer;

import com.coskun.Player;
import com.coskun.hero.Hero;
import com.coskun.inventory.Inventory;
import com.coskun.monster.Monster;

import java.io.IOException;

public interface Printer {

    void printInventory(Inventory inventory) throws IOException;

    void printWarStats(Monster m, Player p);

    void printHeroes(Hero[] heroes) throws IOException;

    void printMenu() throws IOException;

    void printMessage(String message) throws IOException;
}
