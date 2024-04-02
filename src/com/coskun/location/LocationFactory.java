package com.coskun.location;

import static com.coskun.monster.MonsterFactory.MonsterType.BEAR;
import static com.coskun.monster.MonsterFactory.MonsterType.WHALE;
import static com.coskun.monster.MonsterFactory.MonsterType.WOLF;

import com.coskun.Player;
import com.coskun.monster.MonsterFactory;

import java.util.Optional;

public class LocationFactory {


    public static Optional<Location> getLocationFor(int selectedLocation, Player player) {


        if (selectedLocation < 0 || selectedLocation > 5)
            throw new IllegalArgumentException("Geçersiz yer seçimi!");
        switch (selectedLocation) {
            case 0:
                return Optional.empty();
            case 1:
                return Optional.of(new LocationVillageHome(player));
            case 2:
                return Optional.of(new LocationVillageStore(player));

            case 3:
                if (player.getItemAwardList().contains("Kurt Dişi")) {
                    System.out.println("Zaten bu ödülü aldınız!");
                    return Optional.empty();
                }
                return Optional.of(new LocationBattle(
                        player,
                        "Dağ",
                        MonsterFactory.getMonster(WOLF),
                        "Kurt Dişi"));

            case 4:
                if (player.getItemAwardList().contains("Kürk")) {
                    System.out.println("Zaten bu ödülü aldınız!");
                    return Optional.empty();
                }
                return Optional.of(new LocationBattle(
                        player,
                        "Mağara",
                        MonsterFactory.getMonster(BEAR),
                        "Kürk"));

            case 5:
                if (player.getItemAwardList().contains("İnci")) {
                    System.out.println("Zaten bu ödülü aldınız!");
                    return Optional.empty();
                }
                return Optional.of(new LocationBattle(
                        player,
                        "Deniz",
                        MonsterFactory.getMonster(WHALE),
                        "İnci"));
            default:
                return Optional.of(new LocationVillageHome(player));

        }

    }
}
