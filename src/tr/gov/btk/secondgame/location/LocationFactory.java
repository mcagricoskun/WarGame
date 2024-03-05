package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;

import java.util.Optional;

public class LocationFactory {

    public static Optional<Location> getLocationFor(int selectedLocation, Player player) {
        switch (selectedLocation) {
            case 0:
               return Optional.empty();
            case 1:
                return Optional.of(new LocationVillageHome(player));
            case 2:
                return Optional.of(new LocationVillageStore(player));

            case 3:
                return Optional.of(new LocationBattleMountain(player));

            case 4:
                return Optional.of(new LocationBattleCave(player));

            case 5:
                return Optional.of(new LocationBattleSea(player));
            default:
                return Optional.of(new LocationVillageHome(player));

        }

    }
}
