package com.coskun;

import com.coskun.hero.Hero;
import com.coskun.hero.HeroArcher;
import com.coskun.hero.HeroCavalry;
import com.coskun.hero.HeroPaladin;
import com.coskun.inventory.Armor;
import com.coskun.inventory.Inventory;
import com.coskun.inventory.Weapon;
import com.coskun.methods.ConsoleGameInput;
import com.coskun.methods.GameInput;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerDamage;
    private int playerMoney;
    private String heroName;
    private int heroId;
    private Inventory inventory;
    private int defaultHealth;
    private final List<String> itemAwardList = new ArrayList<>();

    //protected Scanner input = new Scanner(System.in);
    protected GameInput input = new ConsoleGameInput();

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }


    public void addAward(String award) {
        itemAwardList.add(award);
    }

    public void selectHero(int heroId) {


        switch (heroId) {
            case 1:
                initPlayer(new HeroArcher());
                break;
            case 2:
                initPlayer(new HeroPaladin());
                break;
            case 3:
                initPlayer(new HeroCavalry());
                break;
            default:
                initPlayer(new HeroArcher());
                break;
        }
        System.out.println(this.playerName + " Seçtin!");
    }

    //mapped player and hero stats
    private void initPlayer(Hero hero) {
        this.setPlayerName(hero.getHeroName());
        this.setPlayerDamage(hero.getHeroDamage());
        this.setPlayerHealth(hero.getHeroHealth());
        this.setPlayerMoney(hero.getHeroGold());
        this.setDefaultHealth(hero.getHeroHealth());
    }
    //TODO: printPlayerInfo() method can be moved to a separate class
    public void printPlayerInfo() {
        System.out.println("Silahınız          : " + this.inventory.getWeapon().getWeaponName());
        System.out.println("Silahınızın Hasarı : " + this.inventory.getWeapon().getWeaponDamage());

        System.out.println("Zırhınız           : " + this.inventory.getArmor().getArmorName());
        System.out.println("Zırhınızın Engeli  : " + this.inventory.getArmor().getArmorBlock());

    }

    public void receivedMonsterDamage(int monsterDamage) {
        System.out.println(getPlayerName() + " --> " + monsterDamage + " hasar aldınız!");
        if (getInventory() != null && getInventory().getArmor() != null) {
            int blockedDamage = getInventory().getArmor().getArmorBlock() - monsterDamage;
            if (blockedDamage <= 0) {
                setPlayerHealth(getPlayerHealth() + blockedDamage);
                getInventory().getArmor().setArmorBlock(0);
            }
            System.out.println(getPlayerHealth() + " canınız kaldı");
        }
    }

    public void buyWeapon(Weapon[] weapons, int selectedWeaponID) {

        Weapon weapon = getWeaponById(weapons, selectedWeaponID);

        while (weapon == null) {
            System.out.println("Geçersiz seçim, tekrar dene:");
            selectedWeaponID = input.nextInt();
            weapon = getWeaponById(weapons, selectedWeaponID);
        }

        if (selectedWeaponID != 0 && selectedWeaponID != this.getInventory().getWeapon().getWeaponId()) {
            Weapon selectedWeapon = getWeaponById(weapons, selectedWeaponID);

            if (selectedWeapon.getWeaponPrice() > this.getPlayerMoney()) {
                System.out.println("Altının yetersiz!");
                System.out.println("Sahip olduğun altın: " + this.getPlayerMoney());
                System.out.println("Almak istediğin silah: " + selectedWeapon.getWeaponPrice() + " altın.");
            } else {
                this.getInventory().setWeapon(selectedWeapon);

                int balance = this.getPlayerMoney() - selectedWeapon.getWeaponPrice();
                this.setPlayerMoney(balance);
                System.out.println(selectedWeapon.getWeaponName() + " Satın aldın! " + this.getPlayerMoney() + " altının kaldı");

                this.printPlayerInfo();
            }
        } else {
            System.out.println("Zaten bu silahı kullanıyorsun!");
        }
    }

    private Weapon getWeaponById(Weapon[] weapons, int selectedWeaponID) {
        for (Weapon w : weapons) {
            if (w.getWeaponId() == selectedWeaponID) {
                return w;
            }
        }
        return null;
    }

    public void buyArmor(Armor[] armors, int selectedArmorID) {

        Armor armor = getArmorById(armors, selectedArmorID);
        while (armor == null) {
            System.out.println("Geçersiz seçim, tekrar dene:");
            selectedArmorID = input.nextInt();
            armor = getArmorById(armors, selectedArmorID);
        }
        if (selectedArmorID != 0 && selectedArmorID != this.getInventory().getArmor().getArmorId()) {
            Armor selectedArmor = getArmorById(armors, selectedArmorID);

            if (selectedArmor.getArmorPrice() > this.getPlayerMoney()) {
                System.out.println("Altının yetersiz!");
                System.out.println("Sahip olduğun altın: " + this.getPlayerMoney());
                System.out.println("Almak istediğin zırh: " + selectedArmor.getArmorPrice() + " altın.");
            } else {
                this.getInventory().setArmor(selectedArmor);

                int balance = this.getPlayerMoney() - selectedArmor.getArmorPrice();
                this.setPlayerMoney(balance);
                System.out.println(selectedArmor.getArmorName() + " Satın aldın!" + " " + this.getPlayerMoney() + " altının kaldı");

                printPlayerInfo();
            }

        } else {
            System.out.println("Zaten bu zırha sahipsin!");
        }

    }

    private Armor getArmorById(Armor[] armors, int id) {
        for (Armor a : armors) {
            if (a.getArmorId() == id) {
                return a;
            }
        }

        return null;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(int playerDamage) {
        this.playerDamage = playerDamage;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = playerHealth;
    }

    public List<String> getItemAwardList() {
        return itemAwardList;
    }

}

