public class locationVillage extends Location{
    public locationVillage(Player player, String locationName) {
        super(player, locationName);
    }

    // player cant die village
    @Override
    boolean onLocation() {
        return true;
    }
}
