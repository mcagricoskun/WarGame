package tr.gov.btk.secondgame;

public class Weapon {
    private int weaponId;
    private String weaponName;
    private int weaponDamage;
    private int weaponPrice;

    public Weapon(int weaponId, String weaponName, int weaponDamage, int weaponPrice) {
        this.weaponId = weaponId;
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.weaponPrice = weaponPrice;
    }

    //weapons adında metod oluşturdum
    private static Weapon [] weapons(){
        // dizi oluşturdum
        Weapon [] weaponList = new Weapon[3];
        //dizi içine elemanaları yerleştirdim
        weaponList [0] = new Weapon(2,"Kılıç",5, 5);
        weaponList [1] = new Weapon(3,"Tabanca",9, 10);
        weaponList [2] = new Weapon(4,"Tüfek",15, 15);
        //dizi elemanlarını dönderdim
        return weaponList;
    }

   public static Weapon getWeaponById(int id){
        for(Weapon w: Weapon.weapons()){
            if(w.getWeaponId() == id){
                return w;
            }
        }
        return null;
   }


    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponPrice() {
        return weaponPrice;
    }

    public void setWeaponPrice(int weaponPrice) {
        this.weaponPrice = weaponPrice;
    }
}
