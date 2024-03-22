package com.coskun.location;

import com.coskun.Player;
import com.coskun.inventory.Armor;
import com.coskun.inventory.Weapon;

public class LocationVillageStore extends LocationVillage {

    private final Weapon[] weapons = {
            new Weapon(1, "Kılıç", 5, 5),
            new Weapon(2, "Tabanca", 9, 10),
            new Weapon(3, "Tüfek", 15, 15),
    };

    private final Armor[] armors = {
            new Armor(1, "Tahta Zırh", 3, 5),
            new Armor(2, "Demir Zırh", 7, 10),
            new Armor(3, "Çelik Zırh", 15, 20),
    };

    public LocationVillageStore(Player player) {
        super(player, "Mağaza");
    }


    @Override
    public boolean enterLocation() {
        System.out.println("Dükkana hoş geldiniz!");
        System.out.println("Silah almak için -------> 1");
        System.out.println("Zırh almak için --------> 2");
        System.out.println("Dükkandan çıkmak için --> 3");

        int decision;
        while (true) {
            String line = input.nextLine().trim();
            if (isNumber(line)) {
                decision = Integer.parseInt(line);
                if (decision >= 1 && decision <= 3) {
                    break;
                } else {
                    System.out.println("Geçerli bir seçim yapmadınız. Tekrar deneyiniz!");
                }
            } else {
//                input.nextInt();
                System.out.println("Geçerli bir tamsayı giriniz. Tekrar deneyiniz!");
            }
        }

        switch (decision) {
            case 1:
                printWeapon();
                sellWeapon(getPlayer());
                break;
            case 2:
                printArmor();
                sellArmor(getPlayer());
                break;
            case 3:
                return true;
        }
        return true;
    }

    private boolean isNumber(String line) {
        for(int i=0; i < line.length(); i++) {
            if(!Character.isDigit(line.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumberEx(String line) {
        try {
            int parsed = Integer.parseInt(line);
            if(parsed > 10) {
                throw new IllegalArgumentException("Number is too high: " + parsed);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void sellWeapon(Player player) {
        System.out.println("Silah almak için lütfen bir ID seçin (Dükkandan çıkmak için -> 0): ");
        int selectedWeaponID = input.nextInt();

        if (selectedWeaponID == 0) {
            System.out.println("İşlem iptal edildi.");
            return;
        }

        player.buyWeapon(weapons, selectedWeaponID);
    }

    public void sellArmor(Player player) {
        System.out.println("Zırh almak için lütfen bir ID seçin (Dükkandan çıkmak için -> 0): ");
        int selectedArmorID = input.nextInt();

        if (selectedArmorID == 0) {
            System.out.println("İşlem iptal edildi.");
            return;
        }

        player.buyArmor(armors, selectedArmorID);
    }

    public void printArmor() {
        System.out.println("Satın alabileceğin silahlar:");
        for (Armor a : armors) {

            int id = a.getArmorId();
            String name = a.getArmorName();
            int price = a.getArmorPrice();
            int block = a.getArmorBlock();

            System.out.println("ID: " + id + " | " + name + " ==> Bloklama: " + block + " Altın: " + price);
        }
    }

    public void printWeapon() {
        System.out.println("Satın alabileceğin silahlar:");
        for (Weapon w : weapons) {

            int id = w.getWeaponId();
            String name = w.getWeaponName();
            int price = w.getWeaponPrice();
            int damage = w.getWeaponDamage();

            System.out.println("ID: " + id + " | " + name + " ==> Hasar: " + damage + " Altın: " + price);
        }
    }

}




