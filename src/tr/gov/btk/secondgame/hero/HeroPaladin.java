package tr.gov.btk.secondgame.hero;

public class HeroPaladin extends Hero {

    //Constructor

    public HeroPaladin(){
        //super olmadan da mümkün ancak üst sınıfa default boş constructor da yazılmalı
//        heroID = 2;
////        heroName = "Şovalye";
////        heroDamage = 5;
////        heroHealth = 25;
////        heroGold = 35;

        super(2, "Şovalye", 5, 25, 35);
    }
}
