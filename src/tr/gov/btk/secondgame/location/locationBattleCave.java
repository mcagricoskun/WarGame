package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.monster.monsterBear;

public class locationBattleCave extends locationBattle{
    public locationBattleCave(Player player) {
        super(player, "Mağara", new monsterBear(),"Kürk",3);
    }

}

