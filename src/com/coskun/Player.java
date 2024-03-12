package com.coskun;

import com.coskun.hero.Hero;
import com.coskun.hero.HeroArcher;
import com.coskun.hero.HeroCavalry;
import com.coskun.hero.HeroPaladin;
import com.coskun.inventory.Inventory;

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
    public void initPlayer(Hero hero) {
        this.setPlayerName(hero.getHeroName());
        this.setPlayerDamage(hero.getHeroDamage());
        this.setPlayerHealth(hero.getHeroHealth());
        this.setPlayerMoney(hero.getHeroGold());
        this.setDefaultHealth(hero.getHeroHealth());
    }

    public void printPlayerInfo() {
        System.out.println("Silahınız          : " + this.inventory.getWeapon().getWeaponName());
        System.out.println("Silahınızın Hasarı : " + this.inventory.getWeapon().getWeaponDamage());

        System.out.println("Zırhınız           : " + this.inventory.getArmor().getArmorName());
        System.out.println("Zırhınızın Engeli  : " + this.inventory.getArmor().getArmorBlock());

    }

    public void receivedMonsterDamage(int monsterDamage){
    System.out.println(getPlayerName() + " --> " + monsterDamage + " hasar aldınız!");
        if ( getInventory() != null && getInventory().getArmor() != null) {
            int blockedDamage = getInventory().getArmor().getArmorBlock() - monsterDamage;
            if (blockedDamage <= 0) {
                setPlayerHealth(getPlayerHealth() + blockedDamage);
                getInventory().getArmor().setArmorBlock(0);
            }
            System.out.println(getPlayerHealth() + " canınız kaldı");
        }
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

