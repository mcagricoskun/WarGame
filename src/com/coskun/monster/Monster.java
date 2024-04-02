package com.coskun.monster;

public class Monster {
    private final String name;
    private final int damage;
    private int health;
    private final int winAward;
    private final int defaultHealth;

    public Monster(String name, int damage, int health, int winAward) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.winAward = winAward;
        this.defaultHealth = health;
    }

       public void receivedPlayerDamage(int playerDamage){
        System.out.println(getName() + " --> " + playerDamage + " hasar vurdunuz!");
        setHealth(getHealth() - playerDamage);
        System.out.println(getName() + " --> " + getHealth() + " canı kaldı!");

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

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWinAward() {
        return winAward;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void resetHealth() {
        this.setHealth((this.getDefaultHealth()));
    }
}
