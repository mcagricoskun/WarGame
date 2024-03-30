package com.coskun.monster;

public class MonsterFactory {

    public enum MonsterType {
        BEAR,
        WHALE,
        WOLF;
    }

    public static Monster getMonster(MonsterType type) {
        switch (type) {
            case BEAR:
                return new Monster("Ayı", 5, 12, 7);
            case WOLF:
                return new Monster("Kurt", 2, 7, 15);
            case WHALE:
                return new Monster("Balina", 7, 15, 11);
            default:
                throw new IllegalArgumentException("Undefined monster type");
        }
    }
}
