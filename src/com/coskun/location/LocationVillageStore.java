package com.coskun.location;

import com.coskun.Player;
import com.coskun.inventory.Armor;
import com.coskun.inventory.Weapon;

public class LocationVillageStore extends LocationVillage {
    private final Weapon[] weapons = {
            new Weapon(2, "Kılıç", 5, 5),
            new Weapon(3, "Tabanca", 9, 10),
            new Weapon(4, "Tüfek", 15, 15),
    };

    public final Armor[] armors = {
            new Armor(2, "Tahta Zırh", 3, 5),
            new Armor(3, "Demir Zırh", 7, 10),
            new Armor(4, "Çelik Zırh", 15, 20),
    };

    public LocationVillageStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
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
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                return true;
        }
        return true;
    }


    public void buyWeapon() {
        System.out.println("Çıkmak için -> 0");
        System.out.println("Almak istediğin silahın ID sini seç!");
        int selectedWeaponID = input.nextInt();

        Weapon weapon = getWeaponById(selectedWeaponID);

        while (weapon == null) {
            System.out.println("Geçersiz seçim, tekrar dene:");
            selectedWeaponID = input.nextInt();
            weapon = getWeaponById(selectedWeaponID);
        }
        if (selectedWeaponID != 0 && selectedWeaponID != this.getPlayer().getInventory().getWeapon().getWeaponId()) {
            Weapon selectedWeapon = getWeaponById(selectedWeaponID);

            if (selectedWeapon.getWeaponPrice() > this.getPlayer().getPlayerMoney()) {
                System.out.println("Altının yetersiz!");
                System.out.println("Sahip olduğun altın: " + this.getPlayer().getPlayerMoney());
                System.out.println("Almak istediğin silah: " + selectedWeapon.getWeaponPrice() + " altın.");
            } else {

                this.getPlayer().getInventory().setWeapon(selectedWeapon);

                // TODO

                int balance = this.getPlayer().getPlayerMoney() - selectedWeapon.getWeaponPrice();
                this.getPlayer().setPlayerMoney(balance);
                System.out.println(selectedWeapon.getWeaponName() + " Satın aldın!" + " " + this.getPlayer().getPlayerMoney() + " altının kaldı");

                getPlayer().printPlayerInfo();
            }

        } else {
            System.out.println("Zaten bu silahı kullanıyorsun!");
        }
    }


    public void buyArmor() {
        System.out.println("Çıkmak için -> 0");
        System.out.println("Almak istediğin zırhın ID sini seç!");
        int selectedArmorID = input.nextInt();

        Armor armor = getArmorById(selectedArmorID);
        while (armor == null) {
            System.out.println("Geçersiz seçim, tekrar dene:");
            selectedArmorID = input.nextInt();
            armor = getArmorById(selectedArmorID);
        }
        if (selectedArmorID != 0 && selectedArmorID != this.getPlayer().getInventory().getArmor().getArmorId()) {
            Armor selectedArmor = getArmorById(selectedArmorID);
            if (selectedArmor.getArmorPrice() > this.getPlayer().getPlayerMoney()) {

                    System.out.println("Altının yetersiz!");
                    System.out.println("Sahip olduğun altın: " + this.getPlayer().getPlayerMoney());
                    System.out.println("Almak istediğin zırh: " + selectedArmor.getArmorPrice() + " altın.");
                } else {
                    this.getPlayer().getInventory().setArmor(selectedArmor);

                    int balance = this.getPlayer().getPlayerMoney() - selectedArmor.getArmorPrice();
                    this.getPlayer().setPlayerMoney(balance);
                    System.out.println(selectedArmor.getArmorName() + " Satın aldın!" + " " + this.getPlayer().getPlayerMoney() + " altının kaldı");

                    getPlayer().printPlayerInfo();
                }
            }
         else {
            System.out.println("Zaten bu zırha sahipsin!");
        }

    }

    private Weapon getWeaponById(int id) {
        for (Weapon w : weapons) {
            if (w.getWeaponId() == id) {
                return w;
            }
        }
        return null;
    }

    private Armor getArmorById(int id) {
        for (Armor a : armors) {
            if (a.getArmorId() == id) {
                return a;
            }
        }

        return null;
    }

    public void printArmor() {
        System.out.println("Satın alabileceğin silahlar:");
        for (Armor a : armors) {

            int id = a.getArmorId();
            String name = a.getArmorName();
            int price = a.getArmorPrice();
            int block = a.getArmorBlock();

            System.out.println("ID: " + id + " | " + name + " ==> Price: " + price + " Block: " + block);
        }

    }

    public void printWeapon() {
        System.out.println("Satın alabileceğin silahlar:");
        for (Weapon w : weapons) {

            int id = w.getWeaponId();
            String name = w.getWeaponName();
            int price = w.getWeaponPrice();
            int damage = w.getWeaponDamage();

            System.out.println("ID: " + id + " | " + name + " --> Hasar: " + damage + " Altın: " + price);
        }

    }
}




