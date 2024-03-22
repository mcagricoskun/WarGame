package com.coskun.monster;

public class Monster {

    private String monsterName;
    private int monsterDamage;
    private int monsterHealth;
    private int winAward;
    private int defaultMonsterHealth;

    public Monster(String monsterName, int monsterDamage, int monsterHealth, int winAward) {
        this.monsterName = monsterName;
        this.monsterDamage = monsterDamage;
        this.monsterHealth = monsterHealth;
        this.winAward = winAward;
        this.defaultMonsterHealth = monsterHealth;
    }

    public void receivedPlayerDamage(int playerDamage) {
        System.out.println(getMonsterName() + " --> " + playerDamage + " hasar vurdunuz!");
        setMonsterHealth(getMonsterHealth() - playerDamage);
        System.out.println(getMonsterName() + " --> " + getMonsterHealth() + " canı kaldı!");

    }


    public void resetHealth() {
        this.setMonsterHealth((this.getDefaultMonsterHealth()));
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getWinAward() {
        return winAward;
    }

    public int getDefaultMonsterHealth() {
        return defaultMonsterHealth;
    }

    public String shout() {
        return "AAAAAAAAAAAAAA";
    }

}
