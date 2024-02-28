import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerDamage;
    private int playerMoney;
    private String heroName;
    private int heroId;
    private Inventory inventory;
    private int defaultHealth;
    public List<String> itemAwardList = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public void selectHero() {
        Hero[] herolist = {new heroArcher(), new heroPaladin(), new heroCavalry()};
        //System.out.println("Hero ID " +"-- "+ "Hero İsmi " +"-- "+ "Hero Hasarı " +"-- "+ "Hero Sağlığı " +"-- "+ "Hero Altın");
        for (Hero hero : herolist) {
            System.out.println( "ID --> "+ hero.getHeroID() + " // "+ "Hero İsmi --> " + hero.getHeroName() +" // "+ "Hero Hasarı --> " + hero.getHeroDamage() +" // "+ "Hero Sağlığı --> " + hero.getHeroHealth() +" // "+ "Hero Altın --> " + hero.getHeroGold());
        }
        System.out.println("--------------");
        System.out.println("Hero seçimini yapınız, ID = ?");
        heroId = input.nextInt();

        switch (heroId) {
            case 1:
                initPlayer(new heroArcher());
                break;
            case 2:
                initPlayer(new heroPaladin());
                break;
            case 3:
                initPlayer(new heroCavalry());
                break;
            default:
                initPlayer(new heroArcher());
                break;
        }
        System.out.println(this.playerName + " Seçtin!");
    }

    //mapped player and hero stats
    public void initPlayer(Hero hero) {
        this.setPlayerName(hero.getHeroName());
        this.setPlayerDamage(hero.getHeroDamage());
        this.setPlayerHealth(hero.getHeroHealth());
        this.setPlayerMoney(hero.getHeroGold());
        this.setDefaultHealth(hero.getHeroHealth());
    }

    public void printPlayerInfo(){
        System.out.println("Silahınız          : " + this.inventory.getWeapon().getWeaponName());
        System.out.println("Silahınızın Hasarı : " + this.inventory.getWeapon().getWeaponDamage());

        System.out.println("Zırhınız           : " + this.inventory.getArmor().getArmorName());
        System.out.println("Zırhınızın Engeli  : " + this.inventory.getArmor().getArmorBlock());

    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(int playerDamage) {
        this.playerDamage = playerDamage;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = playerHealth;
    }
    public List<String> getItemAwardList() {
        return itemAwardList;
    }

    public void setItemAwardList(List<String> itemAwardList) {
        this.itemAwardList = itemAwardList;
    }
}
