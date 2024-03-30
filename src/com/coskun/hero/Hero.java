package com.coskun.hero;

public class  Hero {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int gold;

    public Hero(int id, String name, int damage, int health, int gold) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

}
