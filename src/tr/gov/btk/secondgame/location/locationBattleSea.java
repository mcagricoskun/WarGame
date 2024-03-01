package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.monster.monsterWhale;

public class locationBattleSea extends locationBattle {
    public locationBattleSea(Player player) {
        super(player, "Deniz", new monsterWhale(), "İnci", 3);
    }
}
