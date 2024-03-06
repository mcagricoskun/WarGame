package com.coskun;

import com.coskun.location.Location;
import com.coskun.location.LocationFactory;

import java.util.Optional;
import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start (){
        System.out.println("Hoş geldin, Adınız: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        player.heroList();
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

            int selectedLocation = input.nextInt();

            Optional<Location> location = LocationFactory.getLocationFor(selectedLocation, player);

            if(location.isPresent()) {
                Location actualLocation = location.get();
                if (!actualLocation.onLocation()){
                    if (!actualLocation.onLocation()) {
                        System.out.println("ÖLDÜNÜZ!");
                    }else {
                        System.out.println("Onaylandı!");
                    }
                    break;
                }
            }



        }
    }
}
