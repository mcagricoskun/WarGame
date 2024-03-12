package com.coskun;

import com.coskun.hero.Hero;
import com.coskun.hero.HeroArcher;
import com.coskun.hero.HeroCavalry;
import com.coskun.hero.HeroPaladin;
import com.coskun.location.Location;
import com.coskun.location.LocationFactory;
import com.coskun.methods.ConsoleGameInput;
import com.coskun.methods.GameInput;

import java.util.Optional;

public class Game {
    //private final Scanner input = new Scanner(System.in);

    private static final Hero[] HEROES = {new HeroArcher(), new HeroPaladin(), new HeroCavalry()};
    private GameInput input = new ConsoleGameInput();
    public void start (){
        System.out.println("Hoş geldin, Adınız: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        printHeros();
        //player.heroList();
        int heroId = input.nextInt();
        player.selectHero(heroId);

        player.printPlayerInfo();

        while (true){
            System.out.println("--------------------------------");
            System.out.println("Gitmek istediğiniz yeri seçin: ");
            System.out.println("1 -> Ev");
            System.out.println("2 -> Dükkan");
            System.out.println("3 -> Dağ ----> (Ödül -> Kurt Dişi)");
            System.out.println("4 -> Mağara -> (Ödül -> Kürk)");
            System.out.println("5 -> Deniz --> (Ödül -> İnci)");

            if(player.getItemAwardList().size()==3){
                System.out.println("Tebrikler! Oyunu kazandınız!");

                break;
            }
            else {
                int selectedLocation = input.nextInt();

                Optional<Location> location = LocationFactory.getLocationFor(selectedLocation, player);

                if(location.isPresent()) {
                    //Location actualLocation = location.get();
                    //if (actualLocation.onLocation()== false){
                    if (!location.get().onLocation()){
                        //if (!actualLocation.onLocation()) {
                            System.out.println("ÖLDÜNÜZ!");
                            break;
                        //}
                    }
                }
            }


        }
    }

    public void  printHeros(){
        //System.out.println("Hero ID " +"-- "+ "Hero İsmi " +"-- "+ "Hero Hasarı " +"-- "+ "Hero Sağlığı " +"-- "+ "Hero Altın");
        for (Hero h : HEROES) {
            System.out.println( "ID --> "+ h.getHeroID() + " // "+ "Hero İsmi --> " + h.getHeroName() +" // "+ "Hero Hasarı --> " + h.getHeroDamage() +" // "+ "Hero Sağlığı --> " + h.getHeroHealth() +" // "+ "Hero Altın --> " + h.getHeroGold());
        }

        System.out.println("--------------");
        System.out.println("Hero seçimini yapınız, ID = ?");
    }
}
