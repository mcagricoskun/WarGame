package com.coskun;

import com.coskun.hero.HeroCavalry;
import com.coskun.hero.Hero;
import com.coskun.hero.HeroArcher;
import com.coskun.hero.HeroPaladin;
import com.coskun.inventory.Inventory;
import com.coskun.location.Location;
import com.coskun.monster.Monster;

import java.util.*;

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

    public void processLocations(List<Location> locations) {

    }

    public void addAward(String award) {
        itemAwardList.add(award);
    }

    public void heroList(){
        Hero[] herolist = {new HeroArcher(), new HeroPaladin(), new HeroCavalry()};
        //System.out.println("Hero ID " +"-- "+ "Hero İsmi " +"-- "+ "Hero Hasarı " +"-- "+ "Hero Sağlığı " +"-- "+ "Hero Altın");
        for (Hero hero : herolist) {
            System.out.println( "ID --> "+ hero.getHeroID() + " // "+ "Hero İsmi --> " + hero.getHeroName() +" // "+ "Hero Hasarı --> " + hero.getHeroDamage() +" // "+ "Hero Sağlığı --> " + hero.getHeroHealth() +" // "+ "Hero Altın --> " + hero.getHeroGold());
        }
        System.out.println("--------------");
        System.out.println("Hero seçimini yapınız, ID = ?");

    }
    public void selectHero(int heroId) {
//        Hero[] herolist = {new heroArcher(), new heroPaladin(), new heroCavalry()};
//        //System.out.println("Hero ID " +"-- "+ "Hero İsmi " +"-- "+ "Hero Hasarı " +"-- "+ "Hero Sağlığı " +"-- "+ "Hero Altın");
//        for (Hero hero : herolist) {
//            System.out.println( "ID --> "+ hero.getHeroID() + " // "+ "Hero İsmi --> " + hero.getHeroName() +" // "+ "Hero Hasarı --> " + hero.getHeroDamage() +" // "+ "Hero Sağlığı --> " + hero.getHeroHealth() +" // "+ "Hero Altın --> " + hero.getHeroGold());
//        }
//        System.out.println("--------------");
//        System.out.println("Hero seçimini yapınız, ID = ?");


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

    public void printPlayerInfo(){
        System.out.println("Silahınız          : " + this.inventory.getWeapon().getWeaponName());
        System.out.println("Silahınızın Hasarı : " + this.inventory.getWeapon().getWeaponDamage());

        System.out.println("Zırhınız           : " + this.inventory.getArmor().getArmorName());
        System.out.println("Zırhınızın Engeli  : " + this.inventory.getArmor().getArmorBlock());

    }
    public void playerHit(Monster monster) {
        System.out.println(monster.getMonsterName() + " --> " + getPlayerDamage() + " hasar vurdunuz!");
        monster.setMonsterHealth(monster.getMonsterHealth() - getPlayerDamage());
        System.out.println(monster.getMonsterName() + " --> " + monster.getMonsterHealth() + " canı kaldı!");
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
