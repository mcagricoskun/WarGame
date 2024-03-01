package tr.gov.btk.secondgame;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



public class Armor {
    private int armorId;
    private String armorName;
    private int armorBlock;
    private int armorPrice;

    public Armor(int armorId, String armorName, int armorBlock, int armorPrice) {
        this.armorId = armorId;
        this.armorName = armorName;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[]{new Armor(2, "Tahta Zırh", 3, 5), new Armor(3, "Demir Zırh", 7, 10), new Armor(4, "Çelik Zırh", 15, 20)};
        return armorList;
    }

    public static Armor getArmorById(int id) {
        for (Armor a : armors()) {
            if (a.getArmorId() == id) {
                return a;
            }
        }

        return null;
    }

    public int getArmorId() {
        return this.armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public String getArmorName() {
        return this.armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorBlock() {
        return this.armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return this.armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
