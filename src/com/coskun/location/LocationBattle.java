package com.coskun.location;

import com.coskun.*;
import com.coskun.methods.RandomNumberGenerator;
import com.coskun.methods.GameStatsGenerator;
import com.coskun.monster.Monster;

import java.io.IOException;

public class LocationBattle extends Location {
    private Monster monster;
    private Player player;
    private String itemAward;
    private RandomNumberGenerator randomNumberGenerator;
    private GameStatsGenerator gameStatsGenerator;

    public LocationBattle(Player player, String locationName, Monster monster, String itemAward) {
        super(player, locationName);
        this.monster = monster;
        this.itemAward = itemAward;
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.gameStatsGenerator = new GameStatsGenerator(player, monster);
    }


    public boolean onLocation() throws IOException {

        if (this.getPlayer().getHealth() < 0) {
            return false;
        } else {
            //creates monster random monster count for every area
            int monsterCount = getNumberOfMonsters();

            System.out.println(this.getLocationName() + " Alanına Hoş geldin!" + this.getPlayer().getName());
            System.out.println("Bu alanda (" + this.getLocationName() + ")" + " " + monsterCount + " " + this.getMonster().getName() + " var");

            // Choice of run or fight
            System.out.println("Savaşmak için <s>, kaçmak için <k> bas!");

            String decision = input.nextLine();
            decision = decision.toLowerCase();

            if (decision.equals("s")) {
                return combat(monsterCount);
            } else {
                return true;
            }
        }
    }

    private int getNumberOfMonsters() {
        return randomNumberGenerator.generateRandomNumber(getMaxMonsterCount());
    }

    public boolean combat(int monsterCount) throws IOException {

        // I wrote as many loops as monsters to fight all the monsters
        for (int i = 1; i <= monsterCount; i++) {

            //resets monster health for all loop
            monster.resetHealth();

            //warStats
            gameStatsGenerator.warStats();

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
//                // Player hit
                int playerDamage = getPlayer().getDamage();
                getMonster().receivedPlayerDamage(playerDamage);

                // Monster hit
                if (this.getMonster().getHealth() > 0) {
                    int monsterDamage = getMonster().getDamage();
                    getPlayer().receivedMonsterDamage(monsterDamage);
                } else {
                    System.out.println(i + ". " + this.getMonster().getName() + " öldürüldü!");
                }

            }
        }
        // if player health is less than 0, player dies
        if (this.getPlayer().getHealth() < 0) {
            return false;
        } else {
            System.out.println("Tebrikler! " + monsterCount + " tane " + this.getMonster().getName() + " öldürdünüz!");

            //print end statics at the end of the war
            gameStatsGenerator.endWarStats();
        }
        this.getPlayer().addAward(this.getItemAward());
        System.out.println("Kazandığın ödüller: " + this.getPlayer().getItemAwardList());
        return true;
    }


    public Monster getMonster() {
        return monster;
    }

    public String getItemAward() {
        return itemAward;
    }

    public int getMaxMonsterCount() {
        return 3;
    }
}
