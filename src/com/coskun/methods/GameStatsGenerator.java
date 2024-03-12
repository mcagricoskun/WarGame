package com.coskun.methods;

import com.coskun.Player;
import com.coskun.monster.Monster;

public class GameStatsGenerator {
    private final Player player;
    private Monster monster;

    public GameStatsGenerator(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void warStats() {
        System.out.println("Senin Canın :" + player.getPlayerHealth() + " ve " + player.getInventory().getArmor().getArmorBlock() + " zırhın var");
        System.out.println(monster.getMonsterName() + " canı: " + monster.getMonsterHealth());
        System.out.println("---------------------------------");

    }

    public void endWarStats (){
        System.out.println("Ödülünüz: " + monster.getWinAward());
        player.setPlayerMoney(player.getPlayerMoney() + monster.getWinAward());
        System.out.println("Toplam altının " + player.getPlayerMoney() + " oldu!");
    }
}
