package de.tbag.gbd.gbd_code;

import de.tbag.gbd.combat.Enemy;
import de.tbag.gbd.combat.WeaponType;
import de.tbag.gbd.debug.Debug;
import de.tbag.gbd.misc.Shop;
import de.tbag.gbd.misc.ShopItem;
import de.tbag.gbd.potions.PotionsType;
import de.tbag.gbd.combat.Combat;
import de.tbag.gbd.combat.Weapon;
import de.tbag.gbd.player.Player;
import de.tbag.gbd.potions.Potion;
import de.tbag.gbd.AdventureGame;

import java.util.Scanner;

/**
 * @author Samuel Ratzel | Lukas Knappich | [UR NAME]
 * @version 1.0
 * @since 28.02.24
 */

public class Game {
    private AdventureGame game;
    private Combat combat;
    public String playerName = "";
    private static Enemy enemy;
    private static Potion potions;
    private static PotionsType healSize;
    Scanner inputScanner = new Scanner(System.in);
    Player player;
    Shop shop;
    Debug debug;
    public Game(AdventureGame adventureGame) {
        this.game = adventureGame;
        this.combat = new Combat(adventureGame);
        this.debug = new Debug();
        this.player = new Player(playerName, 100, 10, 3, game);
        this.shop = new Shop(player,3, inputScanner, game);
    }

    Weapon pistole = new Weapon("Pistole", WeaponType.LONG_RANGE, 40, 80, 88, 0.3);
    Weapon messer = new Weapon("Messer", WeaponType.SHORT_RANGE, 10, 15, 20, 0.1);





    public void start(String playerName) throws InterruptedException {
        this.playerName = playerName;
        player.setName(playerName);
        player.showStats();
        game.show("Bitte wähle eine Waffe aus, Pistole oder Messer");
        String eingabe = game.ask("");

        if (eingabe.equalsIgnoreCase("Pistole")) {
            game.show("Du hast eine Pistole gekommen");
            player.addWeapon(pistole);
        } else if (eingabe.equalsIgnoreCase("Messer")) {
            game.show("Du hast eine Messer bekommen");
            player.addWeapon(messer);
        } else {
            game.show("Ungültige Eingabe. Bitte nur 'Pistole' oder 'Messer' eingeben.");
        }

        game.show("Wähle eine Waffe aus deinem INV");
      String inventory = game.ask("Welche waffe möchtest du nutzen");
        player.equipWeapon(messer);

    }
}