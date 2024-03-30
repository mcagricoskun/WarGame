package com.coskun.location;

import static com.coskun.monster.MonsterFactory.MonsterType.WOLF;

import com.coskun.Player;
import com.coskun.monster.MonsterFactory;

public class LocationBattleMountain extends LocationBattle {
    public LocationBattleMountain(Player player) {
        super(player, "Dağ", MonsterFactory.getMonster(WOLF), "Kurt Dişi");
    }

}
