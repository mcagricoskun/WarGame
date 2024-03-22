package com.coskun.monster;

public class MonsterBear extends Monster {
    private int kisUykusuSuresi;

    public MonsterBear(int sure) {
        super("Ayı",5, 5,7);
        this.kisUykusuSuresi = sure;
    }

   @Override
   public String shout() {
        if(time < sure) {
            return "horrrrr";
        } else {
            return "aaaaa";
        }
    }
}
