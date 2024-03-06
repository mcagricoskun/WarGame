package com.coskun.location;

import com.coskun.Player;
import com.coskun.monster.MonsterWhale;

public class LocationBattleSea extends LocationBattle {
    public LocationBattleSea(Player player) {
        super(player, "Deniz", new MonsterWhale(), "İnci");
    }
}
