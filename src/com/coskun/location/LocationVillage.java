package com.coskun.location;

import com.coskun.Player;

public class LocationVillage extends Location {
    public LocationVillage(Player player, String locationName) {
        super(player, locationName);
    }

    // player cant die village
    @Override
    public boolean onLocation() {
        return true;
    }
}
