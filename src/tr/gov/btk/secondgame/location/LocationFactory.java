package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;

import java.util.Optional;

public class LocationFactory {

    public static Optional<Location> getLocationFor(int selectedLocation, Player player) {
        switch (selectedLocation) {
            case 0:
               return Optional.empty();
            case 1:
                return Optional.of(new locationVillageHome(player));
            case 2:
                return Optional.of(new locationVillageStore(player));

            case 3:
                return Optional.of(new locationBattleMountain(player));

            case 4:
                return Optional.of(new locationBattleCave(player));

            case 5:
                return Optional.of(new locationBattleSea(player));
            default:
                return Optional.of(new locationVillageHome(player));

        }

    }
}
