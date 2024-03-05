package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.monster.MonsterBear;

public class LocationBattleCave extends LocationBattle {
    public LocationBattleCave(Player player) {
        super(player, "Mağara", new MonsterBear(),"Kürk");
    }

}

