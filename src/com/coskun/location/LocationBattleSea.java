package com.coskun.location;

import static com.coskun.monster.MonsterFactory.MonsterType.*;

import com.coskun.Player;
import com.coskun.monster.MonsterFactory;

public class LocationBattleSea extends LocationBattle {
    public LocationBattleSea(Player player) {
        super(player, "Deniz", MonsterFactory.getMonster(WHALE), "İnci");
    }
}
