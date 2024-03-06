package com.coskun;

import com.coskun.monster.Monster;

public class WarStatGenerator {
    private Player player;
    private Monster monster;
    private WarStatGenerator warStatGenerator;
    public WarStatGenerator(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
       //this.warStatGenerator = new WarStatGenerator(player, monster);
    }
    public void warStats(){
        System.out.println("Senin Canın :" + getPlayer().getPlayerHealth() + " ve " + getPlayer().getInventory().getArmor().getArmorBlock() + " zırhın var");
        System.out.println(getMonster().getMonsterName() + " canı: " + getMonster().getMonsterHealth());
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
