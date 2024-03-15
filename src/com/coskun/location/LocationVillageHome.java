package com.coskun.location;

import com.coskun.Player;

public class LocationVillageHome extends LocationVillage {
    public LocationVillageHome(Player player) {
        super(player, "Ev");
    }

    @Override
    public boolean enterLocation() {
        System.out.println("Eve hoş geldin, Canın yenilendi!");
        this.getPlayer().setPlayerHealth(getPlayer().getDefaultHealth());
        System.out.println("Yeni canın: " + this.getPlayer().getPlayerHealth());
        return true;
    }
}
