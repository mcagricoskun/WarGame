package tr.gov.btk.secondgame.monster;

import tr.gov.btk.secondgame.Player;

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
    public void monsterHit(Player player) {
        System.out.println(getMonsterName() + " " + getMonsterDamage() + " hasar vurdu!");

        if (player != null && player.getInventory() != null && player.getInventory().getArmor() != null) {
            int blockedDamage = player.getInventory().getArmor().getArmorBlock() - getMonsterDamage();

            if (blockedDamage <= 0) {
                player.setPlayerHealth(player.getPlayerHealth() + blockedDamage);
                player.getInventory().getArmor().setArmorBlock(0);
            }

            System.out.println(player.getPlayerHealth() + " canınız kaldı");
        }
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
}
