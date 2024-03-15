package com.coskun.location;

import com.coskun.Player;
import com.coskun.methods.ConsoleGameInput;
import com.coskun.methods.GameInput;

public abstract class Location {

    private  final Player player;
    private  String locationName;
    //protected Scanner input = new Scanner(System.in); // Scanner can be used anywhere under location
    protected GameInput input = new ConsoleGameInput();

    protected Location(Player player, String locationName) {
        this.player = player;
        this.locationName = locationName;
    }

    public abstract boolean enterLocation();

    public Player getPlayer() {
        return player;
    }

    public String getLocationName() {
        return locationName;
    }

}
