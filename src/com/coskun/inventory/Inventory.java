package com.coskun.inventory;

public class Inventory {
    private Armor armor;
    private Weapon weapon;

    public Inventory(){
        this.weapon = new Weapon(1,"Yumruk",3,0);
        this.armor = new Armor(1, "Paçavra", 2,0);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapons) {
        this.weapon = weapons;
    }
}
