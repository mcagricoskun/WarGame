package com.coskun.location;

import com.coskun.Player;

import java.io.IOException;

public class LocationVillage extends Location {
    public LocationVillage(Player player, String locationName) {
        super(player, locationName);
    }

    // player cant die village
    @Override
    public boolean onLocation() throws IOException {
        return true;
    }
}
