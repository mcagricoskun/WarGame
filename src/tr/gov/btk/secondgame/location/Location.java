package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;

import java.util.Scanner;

public abstract class Location {
    protected Scanner input = new Scanner(System.in); // Scanner can be used anywhere under location
    private final Player player;
    private final String locationName;

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
