package com.coskun.inventory;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

}
