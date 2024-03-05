package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.monster.MonsterWhale;

public class LocationBattleSea extends LocationBattle {
    public LocationBattleSea(Player player) {
        super(player, "Deniz", new MonsterWhale(), "İnci");
    }
}
