package com.coskun.hero;

public class HeroFactory {

    public enum HeroType{
        ARCHER,
        PALADIN,
        CAVALRY
    }
    public static Hero getHero(HeroType heroType){
        switch (heroType){
            case ARCHER:
                return new Hero(1, "Okçu", 3, 12, 30);
            case PALADIN:
                return new Hero(2, "Şovalye", 5, 25, 35);
            case CAVALRY:
                return new Hero(3, "Atlı", 10, 35, 55);
            default:
                throw new IllegalArgumentException("Unknown hero type");
        }
    }
}
