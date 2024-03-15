package com.coskun.location;

import com.coskun.Player;

import java.util.Optional;

public class LocationFactory {


    public static Optional<Location> getLocationFor(int selectedLocation, Player player) {


        if(selectedLocation < 0 || selectedLocation > 5)
            throw new IllegalArgumentException("Geçersiz yer seçimi!");
        switch (selectedLocation) {
            case 0:
               return Optional.empty();
            case 1:
                System.out.println("Eve dönüyorsunuz...");
                return Optional.of(new LocationVillageHome(player));
            case 2:
                System.out.println("Köy dükkanına gidiyorsunuz...");
                return Optional.of(new LocationVillageStore(player));

            case 3:
                if(player.getItemAwardList().contains("Kurt Dişi")){
                    System.out.println("Zaten bu ödülü aldınız!");
                    return Optional.empty();
                }
                return Optional.of(new LocationBattleMountain(player));

            case 4:
                if(player.getItemAwardList().contains("Kürk")){
                    System.out.println("Zaten bu ödülü aldınız!");
                    return Optional.empty();
                }
                return Optional.of(new LocationBattleCave(player));

            case 5:
                if(player.getItemAwardList().contains("İnci")){
                    System.out.println("Zaten bu ödülü aldınız!");
                    return Optional.empty();
                }
                return Optional.of(new LocationBattleSea(player));
            default:
                return Optional.of(new LocationVillageHome(player));

        }

    }
}
