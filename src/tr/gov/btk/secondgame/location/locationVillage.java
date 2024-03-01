package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;

public class locationVillage extends Location {
    public locationVillage(Player player, String locationName) {
        super(player, locationName);
    }

    // player cant die village
    @Override
    public boolean onLocation() {
        return true;
    }
}
