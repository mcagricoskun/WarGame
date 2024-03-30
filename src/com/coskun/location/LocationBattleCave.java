package com.coskun.location;

import static com.coskun.monster.MonsterFactory.MonsterType.BEAR;

import com.coskun.Player;
import com.coskun.monster.MonsterFactory;

public class LocationBattleCave extends LocationBattle {
    public LocationBattleCave(Player player) {
        super(player, "Mağara", MonsterFactory.getMonster(BEAR), "Kürk");
    }

}

