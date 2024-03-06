package com.coskun.location;

import com.coskun.Player;
import com.coskun.monster.MonsterBear;

public class LocationBattleCave extends LocationBattle {
    public LocationBattleCave(Player player) {
        super(player, "Mağara", new MonsterBear(),"Kürk");
    }

}

