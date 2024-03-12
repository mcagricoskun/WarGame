package com.coskun.inventory;

public class Weapon {
    private int weaponId;
    private String weaponName;
    private int weaponDamage;
    private int weaponPrice;

    public Weapon(int weaponId, String weaponName, int weaponDamage, int weaponPrice) {
        this.weaponId = weaponId;
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.weaponPrice = weaponPrice;
    }




    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponPrice() {
        return weaponPrice;
    }

    public void setWeaponPrice(int weaponPrice) {
        this.weaponPrice = weaponPrice;
    }

}
