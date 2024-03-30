package com.coskun;

import com.coskun.hero.Hero;
import com.coskun.hero.HeroFactory;
import com.coskun.location.Location;
import com.coskun.location.LocationFactory;
import com.coskun.methods.ConsoleGameInput;
import com.coskun.methods.GameInput;
import com.coskun.printer.ConsolePrinter;
import com.coskun.printer.FilePrinter;
import com.coskun.printer.Printer;

import java.io.IOException;
import java.util.Optional;

public class Game {
    //private final Scanner input = new Scanner(System.in);

    private static final Hero[] HEROES = {
            HeroFactory.getHero(HeroFactory.HeroType.ARCHER),
            HeroFactory.getHero(HeroFactory.HeroType.PALADIN),
            HeroFactory.getHero(HeroFactory.HeroType.CAVALRY),
    };

    private Printer printer;
    private GameInput input = new ConsoleGameInput();

    public void start() throws IOException {

        printer = new ConsolePrinter(new FilePrinter());
        printer.printMessage("Hoş geldin, Adınız: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName, printer);

        printer.printHeroes(HEROES);
        int heroId = input.nextInt();
        player.selectHero(heroId);
        printer.printInventory(player.getInventory());

        while (true) {
            printer.printMenu();
            if (player.getItemAwardList().size() == 3) {
                printer.printMessage("Tebrikler! Oyunu kazandınız!");
                break;
            } else {
                int selectedLocation = input.nextInt();

                Optional<Location> location = LocationFactory.getLocationFor(selectedLocation, player);

                if (location.isPresent()) {
                    if (!location.get().onLocation()) {
                        printer.printMessage("ÖLDÜNÜZ!");
                        break;

                    }
                }
            }


        }
    }

}
