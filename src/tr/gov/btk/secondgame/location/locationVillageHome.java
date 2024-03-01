package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Player;

public class locationVillageHome extends locationVillage{
    public locationVillageHome(Player player) {
        super(player, "Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Eve hoş geldin, Canın yenilendi!");
        this.getPlayer().setPlayerHealth(getPlayer().getDefaultHealth());
        return true;
    }
}
