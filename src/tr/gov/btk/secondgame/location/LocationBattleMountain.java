package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.monster.MonsterWolf;

public class LocationBattleMountain extends LocationBattle {
    public LocationBattleMountain(Player player) {
        super(player, "Dağ", new MonsterWolf(), "Kurt Dişi");
    }
}
