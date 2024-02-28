import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);



    public void start (){
        System.out.println("Hoş geldin, Adınız: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        player.selectHero();

        Location location;
        player.printPlayerInfo();

        while (true){
            System.out.println("--------------------------------");
            System.out.println("Gitmek istediğiniz yeri seçin: ");
            System.out.println("1 -> Ev");
            System.out.println("2 -> Dükkan");
            System.out.println("3 -> Dağ ----> (Ödül -> Kurt Dişi)");
            System.out.println("4 -> Mağara -> (Ödül -> Kürk)");
            System.out.println("5 -> Deniz --> (Ödül -> İnci)");

            int selectedLocation = input.nextInt();

            switch (selectedLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new locationVillageHome(player);
                    break;
                case 2:
                    location = new locationVillageStore(player);
                    break;
                case 3:
                    location = new locationBattleMountain(player);
                    break;
                case 4:
                    location = new locationBattleCave(player);
                    break;
                case 5:
                    location= new locationBattleSea(player);
                    break;
                default:
                    location = new locationVillageHome(player);
                    break;
            }
            if (location == null || !location.onLocation()){
                if (!location.onLocation()) {
                    System.out.println("ÖLDÜNÜZ!");
                }else {
                    System.out.println("Onaylandı!");
                }
                break;
            }
        }
    }
}
