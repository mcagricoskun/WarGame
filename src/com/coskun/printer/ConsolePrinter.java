package com.coskun.printer;

import com.coskun.Player;
import com.coskun.hero.Hero;
import com.coskun.inventory.Inventory;
import com.coskun.monster.Monster;

import java.io.IOException;

public class ConsolePrinter implements Printer {

    private Printer debugPrinter;

    public ConsolePrinter() {

    }

    public ConsolePrinter(Printer debugPrinter) {
        this.debugPrinter = debugPrinter;
    }

    @Override
    public void printInventory(Inventory inventory) throws IOException {
        System.out.println("Silahınız          : " + inventory.getWeapon().getName());
        System.out.println("Silahınızın Hasarı : " + inventory.getWeapon().getDamage());
        System.out.println("Zırhınız           : " + inventory.getArmor().getName());
        System.out.println("Zırhınızın Engeli  : " + inventory.getArmor().getBlock());
        if (this.debugPrinter != null)
            this.debugPrinter.printInventory(inventory);
    }

    @Override
    public void printWarStats(Monster m, Player p) {

    }

    @Override
    public void printHeroes(Hero[] heroes) throws IOException {
        for (Hero h : heroes) {
            System.out.println("ID --> " + h.getId() + " // " + "Hero İsmi --> " + h.getName()
                    + " // " + "Hero Hasarı --> " + h.getDamage() + " // " + "Hero Sağlığı --> " +
                    h.getHealth() + " // " + "Hero Altın --> " + h.getGold());
        }
        System.out.println("--------------");
        System.out.println("Hero seçimini yapınız, ID = ?");
        if (this.debugPrinter != null)
            this.debugPrinter.printHeroes(heroes);
    }


    @Override
    public void printMenu() throws IOException {
        System.out.println("--------------------------------");
        System.out.println("Gitmek istediğiniz yeri seçin: ");
        System.out.println("1 -> Ev");
        System.out.println("2 -> Dükkan");
        System.out.println("3 -> Dağ ----> (Ödül -> Kurt Dişi)");
        System.out.println("4 -> Mağara -> (Ödül -> Kürk)");
        System.out.println("5 -> Deniz --> (Ödül -> İnci)");
        if (this.debugPrinter != null)
            this.debugPrinter.printMenu();
    }

    @Override
    public void printMessage(String message) throws IOException {
        System.out.println(message);
        if (this.debugPrinter != null)
            this.debugPrinter.printMessage(message);
    }
}
