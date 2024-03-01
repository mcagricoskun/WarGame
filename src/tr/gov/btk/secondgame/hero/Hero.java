package tr.gov.btk.secondgame.hero;

public abstract class  Hero {
    int heroID;
    String heroName;
    int heroDamage;
    int heroHealth;
    int heroGold;

    public Hero(int heroID, String heroName, int heroDamage, int heroHealth, int heroGold) {
        this.heroID = heroID;
        this.heroName = heroName;
        this.heroDamage = heroDamage;
        this.heroHealth = heroHealth;
        this.heroGold = heroGold;
    }

    public int getHeroID() {
        return heroID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroDamage() {
        return heroDamage;
    }

    public void setHeroDamage(int heroDamage) {
        this.heroDamage = heroDamage;
    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public void setHeroHealth(int heroHealth) {
        this.heroHealth = heroHealth;
    }

    public int getHeroGold() {
        return heroGold;
    }

    public void setHeroGold(int heroGold) {
        this.heroGold = heroGold;
    }
}
