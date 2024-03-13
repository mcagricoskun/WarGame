package com.coskun.inventory;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



public class Armor {
    private int armorId;
    private String armorName;
    private int armorBlock;
    private int armorPrice;

    public Armor(int armorId, String armorName, int armorBlock, int armorPrice) {
        this.armorId = armorId;
        this.armorName = armorName;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    }



    public int getArmorId() {
        return this.armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public String getArmorName() {
        return this.armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorBlock() {
        return this.armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return this.armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
