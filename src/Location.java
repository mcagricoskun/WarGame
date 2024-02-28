import java.util.Scanner;

public abstract class Location {

    public static Scanner input = new Scanner(System.in); // Scanner can be used anywhere under location
    private Player player;
    private String locationName;

    public Location(Player player, String locationName) {
        this.player = player;
        this.locationName = locationName;
    }

    abstract boolean onLocation();
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
