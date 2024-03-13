package com.coskun.monster;

public class Monster {
    private int monsterId;
    private String monsterName;
    private int monsterDamage;
    private int monsterHealth;
    private int winAward;
    private int defaultMonsterHealth;

    public Monster(int monsterId, String monsterName, int monsterDamage, int monsterHealth, int winAward) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.monsterDamage = monsterDamage;
        this.monsterHealth = monsterHealth;
        this.winAward = winAward;
        this.defaultMonsterHealth = monsterHealth;
    }

       public void receivedPlayerDamage(int playerDamage){
        System.out.println(getMonsterName() + " --> " + playerDamage + " hasar vurdunuz!");
        setMonsterHealth(getMonsterHealth() - playerDamage);
        System.out.println(getMonsterName() + " --> " + getMonsterHealth() + " canı kaldı!");

    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
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

    public void setWinAward(int winAward) {
        this.winAward = winAward;
    }

    public int getDefaultMonsterHealth() {
        return defaultMonsterHealth;
    }

    public void setDefaultMonsterHealth(int defaultMonsterHealth) {
        this.defaultMonsterHealth = defaultMonsterHealth;
    }

    public void resetHealth() {
        this.setMonsterHealth((this.getDefaultMonsterHealth()));
    }
}
