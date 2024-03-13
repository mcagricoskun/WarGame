package com.coskun.location;

import com.coskun.Player;
import com.coskun.monster.MonsterWolf;

public class LocationBattleMountain extends LocationBattle {
    public LocationBattleMountain(Player player) {
        super(player, "Dağ", new MonsterWolf(), "Kurt Dişi");
    }

}
