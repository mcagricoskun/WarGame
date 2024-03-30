package com.coskun.location;

import com.coskun.Player;

public class LocationVillageHome extends LocationVillage {
    public LocationVillageHome(Player player) {
        super(player, "Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Eve hoş geldin, Canın yenilendi!");
        this.getPlayer().setHealth(getPlayer().getDefaultHealth());
        return true;
    }
}
