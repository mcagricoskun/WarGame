package tr.gov.btk.secondgame.location;

import tr.gov.btk.secondgame.Armor;
import tr.gov.btk.secondgame.Player;
import tr.gov.btk.secondgame.Weapon;

public class LocationVillageStore extends LocationVillage {
    public LocationVillageStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Dükkana hoş geidin!");
        System.out.println("Silah almak için -------> 1");
        System.out.println("Zırh almak için --------> 2");
        System.out.println("Dükkandan çıkmak için --> 3");

        int decision = input.nextInt();
        while (decision < 1 || decision > 3) {
            System.out.println("Yanlış seçin yaptın, tekrar dene!");
            decision = input.nextInt();
        }

        switch (decision) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                return true;
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Satın alabileceğin silahlar:");
        for (Weapon w : Weapon.weapons()) {

            int id = w.getWeaponId();
            String name = w.getWeaponName();
            int price = w.getWeaponPrice();
            int damage = w.getWeaponDamage();

            System.out.println("ID: " + id + " | " + name + " --> Hasar: " + damage + " Altın: " + price);
        }

    }


    public void buyWeapon() {
        System.out.println("Çıkmak için -> 0");
        System.out.println("Almak istediğin silahın ID sini seç!");
        int selectedWeaponID = input.nextInt();
        Weapon weapon = Weapon.getWeaponById(selectedWeaponID);
        while (weapon == null) {
            System.out.println("Geçersiz seçim, tekrar dene:");
            selectedWeaponID = input.nextInt();
            weapon = Weapon.getWeaponById(selectedWeaponID);
        }
        if (selectedWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectedWeaponID);
            //With second part, I checked whether the player has the selected weapon or not.
            if (selectedWeapon != null && this.getPlayer().getInventory().getWeapon().getWeaponId() != selectedWeapon.getWeaponId()) {
                if (selectedWeapon.getWeaponPrice() > this.getPlayer().getPlayerMoney()) {
                    System.out.println("Altının yetersiz!");
                    System.out.println("Sahip olduğun altın: " + this.getPlayer().getPlayerMoney());
                    System.out.println("Almak istediğin silah: " + selectedWeapon.getWeaponPrice() + " altın.");
                } else {

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                    int balance = this.getPlayer().getPlayerMoney() - selectedWeapon.getWeaponPrice();
                    this.getPlayer().setPlayerMoney(balance);
                    System.out.println(selectedWeapon.getWeaponName() + " Satın aldın!" + " " + this.getPlayer().getPlayerMoney() + " altının kaldı");

                    getPlayer().printPlayerInfo();
                }

            } else {
                System.out.println("Zaten bu silahı kullanıyorsun!");
            }
        }

    }

    public void printArmor() {
        System.out.println("Satın alabileceğin silahlar:");
        for (Armor a : Armor.armors()) {

            int id = a.getArmorId();
            String name = a.getArmorName();
            int price = a.getArmorPrice();
            int block = a.getArmorBlock();

            System.out.println("ID: " + id + " | " + name + " ==> Price: " + price + " Block: " + block);
        }

    }

    public void buyArmor() {
        System.out.println("Çıkmak için -> 0");
        System.out.println("Almak istediğin zırhın ID sini seç!");

        int selectedArmorID = input.nextInt();
        while (selectedArmorID < 0 || selectedArmorID > Armor.armors().length + 1) {
            System.out.println("Geçersiz seçim, tekrar dene:");
            selectedArmorID = input.nextInt();
        }
        if (selectedArmorID != 0 && selectedArmorID != this.getPlayer().getInventory().getArmor().getArmorId()) {
            Armor selectedArmor = Armor.getArmorById(selectedArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getArmorPrice() > this.getPlayer().getPlayerMoney()) {
                    System.out.println("Altının yetersiz!");
                    System.out.println("Sahip olduğun altın: " + this.getPlayer().getPlayerMoney());
                    System.out.println("Almak istediğin zırh: " + selectedArmor.getArmorPrice() + " altın.");
                } else {
                    this.getPlayer().getInventory().setArmor(selectedArmor);

                    int balance = this.getPlayer().getPlayerMoney() - selectedArmor.getArmorPrice();
                    this.getPlayer().setPlayerMoney(balance);
                    System.out.println(selectedArmor.getArmorName() + " Satın aldın!" + " " + this.getPlayer().getPlayerMoney() + " altının kaldı");

                    getPlayer().printPlayerInfo();
                }
            }
        } else {
            System.out.println("Zaten bu zırha sahipsin!");
        }

    }
}

