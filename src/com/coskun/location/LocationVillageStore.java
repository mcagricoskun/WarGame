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
        System.out.println("Dükkana hoş geidin!");
        System.out.println("Silah almak için -------> 1");
        System.out.println("Zırh almak için --------> 2");
        System.out.println("Dükkandan çıkmak için --> 3");

        int decision = input.nextInt();
        while (decision < 1 || decision > 3) {
            System.out.println("Yanlış seçin yaptın, tekrar dene!");
            decision = input.nextInt();
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
    public void sellWeapon(Player player) {
        System.out.println("Silah almak için lütfen bir ID seçin (Dükkandan çıkmak için -> 0): ");
        int selectedWeaponIDddd = input.nextInt();

        if (selectedWeaponIDddd == 0) {
            System.out.println("İşlem iptal edildi.");
            return;
        }

        player.buyWeapon(weapons, selectedWeaponIDddd);
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




