package com.coskun.location;

import com.coskun.Player;

import java.util.Scanner;

public abstract class Location {

    private  Player player;
    private  String locationName;
    protected Scanner input = new Scanner(System.in); // Scanner can be used anywhere under location


    public Location(Player player, String locationName) {
        this.player = player;
        this.locationName = locationName;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public String getLocationName() {
        return locationName;
    }

}
