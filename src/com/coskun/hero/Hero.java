package com.coskun.hero;

public abstract class  Hero {
    int id;
    String name;
    int damage;
    int health;
    int gold;

    protected Hero(int heroID, String heroName, int heroDamage, int heroHealth, int heroGold) {
        this.id = heroID;
        this.name = heroName;
        this.damage = heroDamage;
        this.health = heroHealth;
        this.gold = heroGold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
