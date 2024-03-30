package com.coskun.printer;

import com.coskun.Player;
import com.coskun.hero.Hero;
import com.coskun.inventory.Inventory;
import com.coskun.monster.Monster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private BufferedWriter openFile() {
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("out.txt", true); //true tells to append data.
            out = new BufferedWriter(fstream);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return out;
    }

    @Override
    public void printInventory(Inventory inventory) throws IOException {
        BufferedWriter out = openFile();
        out.write("Silahınız          : " + inventory.getWeapon().getName() + "\n");
        out.write(("Silahınızın Hasarı : " + inventory.getWeapon().getDamage()) + "\n");
        out.write("Zırhınız           : " + inventory.getArmor().getName() + "\n");
        out.write("Zırhınızın Engeli  : " + inventory.getArmor().getBlock() + "\n");
        out.close();
    }

    @Override
    public void printWarStats(Monster m, Player p) {

    }

    @Override
    public void printHeroes(Hero[] heroes) throws IOException {
        BufferedWriter out = openFile();
        for (Hero h : heroes) {
            out.write("ID --> " + h.getId() + " // " + "Hero İsmi --> " + h.getName()
                    + " // " + "Hero Hasarı --> " + h.getDamage() + " // " + "Hero Sağlığı --> " +
                    h.getHealth() + " // " + "Hero Altın --> " + h.getGold() + "\n");
        }
        out.write("--------------\n");
        out.write("Hero seçimini yapınız, ID = ?\n");
        out.close();
    }

    @Override
    public void printMenu() throws IOException {
        BufferedWriter out = openFile();
        out.write("--------------------------------");
        out.write("Gitmek istediğiniz yeri seçin: ");
        out.write("1 -> Ev");
        out.write("2 -> Dükkan");
        out.write("3 -> Dağ ----> (Ödül -> Kurt Dişi)");
        out.write("4 -> Mağara -> (Ödül -> Kürk)");
        out.write("5 -> Deniz --> (Ödül -> İnci)");
        out.close();
    }

    @Override
    public void printMessage(String message) throws IOException {
        BufferedWriter out = openFile();
        out.write(message+"\n");
        out.close();
    }
}
