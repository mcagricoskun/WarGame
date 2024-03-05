package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.RandomNumberGenerator;
import tr.gov.btk.secondgame.monster.Monster;
import tr.gov.btk.secondgame.Player;

import java.util.Random;

public abstract class LocationBattle extends Location {
    private Monster monster;
    private String itemAward;
    private RandomNumberGenerator randomNumberGenerator;


    public LocationBattle(Player player, String locationName, Monster monster, String itemAward) {
        super(player, locationName);
        this.monster = monster;
        this.itemAward = itemAward;
        this.randomNumberGenerator = new RandomNumberGenerator();

    }

    public boolean onLocation() {

        if (this.getPlayer().getPlayerHealth() < 0) {
//            System.out.println("ÖLDÜNNNNNN");
            return false;
        } else {
            int monsterCount = randomMonsterCount();
            System.out.println(getLocationName() + " Alanına Hoş geldin!" + this.getPlayer().getPlayerName());
            System.out.println("Bu alanda (" + getLocationName() + ")" + " " + monsterCount + " " + getMonster().getMonsterName() + " var");
            // Choice of run or fight
            System.out.println("Savaşmak için <s>, kaçmak için <k> bas!");
            String decision = input.nextLine();
            // I have changed the option entered by the player to lower case
            decision = decision.toLowerCase();

            if (decision.equals("s")) {
                boolean result = combat(monsterCount);
                return result;
            } else {
                return true;
            }
        }
    }

    public boolean combat(int monsterCount) {

        // I wrote as many loops as monsters to fight all the monsters
        for (int i = 1; i <= monsterCount; i++) {
            this.getMonster().setMonsterHealth((this.getMonster().getDefaultMonsterHealth()));
            warStats();
            if (this.getPlayer().getPlayerHealth() > 0) {
                if (this.getMonster().getMonsterHealth() > 0) {
                    // Player hit
                    getPlayer().playerHit(getMonster());
                    // Monster hit
                    if (this.getMonster().getMonsterHealth() > 0) {
                        getMonster().monsterHit(getPlayer());
//                                           } else {
                        System.out.println("Kaçtınız!");
                        return false;
                    }
                }

            } else {
                //System.out.println("Oyun bitti!");
                //return false;
                break;
            }

        }
        // if player health is less than 0, player dies
        if (this.getPlayer().getPlayerHealth() < 0) {
            return false;
        } else {
            System.out.println("Tebrikler! " + monsterCount + " tane " + this.getMonster().getMonsterName() + " öldürdünüz!");
            System.out.println("Ödülünüz: " + this.getMonster().getWinAward());
            this.getPlayer().setPlayerMoney(this.getPlayer().getPlayerMoney() + this.getMonster().getWinAward());
            System.out.println("Toplam altının " + this.getPlayer().getPlayerMoney() + " oldu!");
        }
        this.getPlayer().addAward(this.getItemAward());
        System.out.println("Kazandığın ödüller: " + this.getPlayer().getItemAwardList());
        return true;
    }

    public int randomMonsterCount() {
        //+1 because monster count cant be 0
        return randomNumberGenerator.generateRandomNumber(getMaxMonsterCount()) + 1;
    }

    public void warStats() {

        System.out.println("Senin Canın :" + getPlayer().getPlayerHealth() + " ve " + getPlayer().getInventory().getArmor().getArmorBlock() + " zırhın var");
        System.out.println(getMonster().getMonsterName() + " canı: " + getMonster().getMonsterHealth());
    }


    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getItemAward() {
        return itemAward;
    }

    public void setItemAward(String itemAward) {
        this.itemAward = itemAward;
    }

    public int getMaxMonsterCount() {
        return 3;
    }


}
