package com.coskun;

import com.coskun.hero.Hero;
import com.coskun.hero.HeroFactory;
import com.coskun.inventory.Armor;
import com.coskun.inventory.Inventory;
import com.coskun.inventory.Weapon;
import com.coskun.printer.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private int health;
    private int damage;
    private int money;
    private int defaultHealth;
    private Inventory inventory;

    private Hero hero;

    private final List<String> itemAwardList = new ArrayList<>();

    protected Scanner input = new Scanner(System.in);

    private Printer printer;

    public Player(String name,Printer printer) {
        this.name = name;
        this.printer = printer;
        this.inventory = new Inventory();
    }


    public void addAward(String award) {
        itemAwardList.add(award);
    }

    public void selectHero(int heroId) throws IOException {

        switch (heroId) {
            case 1:
                initPlayer(HeroFactory.getHero(HeroFactory.HeroType.ARCHER));
                break;
            case 2:
                initPlayer(HeroFactory.getHero(HeroFactory.HeroType.PALADIN));
                break;
            case 3:
                initPlayer(HeroFactory.getHero(HeroFactory.HeroType.CAVALRY));
                break;
        }
        printer.printMessage(this.name + " Seçtin!");
    }

    //mapped player and hero stats
    private void initPlayer(Hero hero) {
        this.hero = hero;
        this.setName(hero.getName());
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setMoney(hero.getGold());
        this.setDefaultHealth(hero.getHealth());
    }

    public void receivedMonsterDamage(int monsterDamage) throws IOException {
        printer.printMessage(getName() + " --> " + monsterDamage + " hasar aldınız!");
        if (getInventory() != null && getInventory().getArmor() != null) {
            int blockedDamage = getInventory().getArmor().getBlock() - monsterDamage;
            if (blockedDamage <= 0) {
                setHealth(getHealth() + blockedDamage);
                getInventory().getArmor().setBlock(0);
            }
            printer.printMessage(getHealth() + " canınız kaldı");
        }
    }

    public Weapon tryGettingWeapon(Weapon[] weapons, int selectedWeaponID) throws IOException {
        Weapon weapon = inventory.getWeaponById(weapons, selectedWeaponID);
        while (weapon == null) {
            printer.printMessage("Geçersiz seçim, tekrar dene:");
            selectedWeaponID = input.nextInt();
            weapon = inventory.getWeaponById(weapons, selectedWeaponID);
        }
        if (!isBuyable(weapon)) {
            printer.printMessage("Altının yetersiz!");
            printer.printMessage("Sahip olduğun altın: " + this.getMoney());
            printer.printMessage("Almak istediğin silah: " + weapon.getPrice() + " altın.");
            return null;
        }
        return weapon;
    }

    public boolean isBuyable(Weapon weapon) {
        return weapon.getPrice() <= this.money;
    }

    public void buyWeapon(Weapon[] weapons, int selectedWeaponID) throws IOException {
        if (selectedWeaponID == 0)
            return;
        if (selectedWeaponID == this.inventory.getWeapon().getId()) {
            printer.printMessage("Zaten bu silahı kullanıyorsun!");
            return;
        }
        Weapon selectedWeapon = tryGettingWeapon(weapons, selectedWeaponID);
        if(selectedWeapon == null)
            return;
        this.getInventory().setWeapon(selectedWeapon);
        this.setMoney(this.getMoney() - selectedWeapon.getPrice());
        printer.printMessage(selectedWeapon.getName() + " Satın aldın! " + this.getMoney() + " altının kaldı");
        printer.printInventory(inventory);
    }

    public void buyArmor(Armor[] armors, int selectedArmorID) throws IOException {

        Armor armor = inventory.getArmorById(armors, selectedArmorID);
        while (armor == null) {
            printer.printMessage("Geçersiz seçim, tekrar dene:");
            selectedArmorID = input.nextInt();
            armor = inventory.getArmorById(armors, selectedArmorID);
        }
        if (selectedArmorID != 0 && selectedArmorID != this.getInventory().getArmor().getId()) {
            Armor selectedArmor = inventory.getArmorById(armors, selectedArmorID);

            if (selectedArmor.getPrice() > this.getMoney()) {
                printer.printMessage("Altının yetersiz!");
                printer.printMessage("Sahip olduğun altın: " + this.getMoney());
                printer.printMessage("Almak istediğin zırh: " + selectedArmor.getPrice() + " altın.");
            } else {
                this.getInventory().setArmor(selectedArmor);

                int balance = this.getMoney() - selectedArmor.getPrice();
                this.setMoney(balance);
                printer.printMessage(selectedArmor.getName() + " Satın aldın!" + " " + this.getMoney() + " altının kaldı");
                printer.printInventory(inventory);
            }

        } else {
            printer.printMessage("Zaten bu zırha sahipsin!");
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public List<String> getItemAwardList() {
        return itemAwardList;
    }

}

