package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.monster.monsterWolf;

public class locationBattleMountain extends locationBattle{
    public locationBattleMountain(Player player) {
        super(player, "Dağ", new monsterWolf(), "Kurt Dişi",4);
    }
}
