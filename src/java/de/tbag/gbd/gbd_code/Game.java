package de.tbag.gbd.gbd_code;

import de.tbag.gbd.combat.Enemy;
import de.tbag.gbd.debug.Debug;
import de.tbag.gbd.misc.Shop;
import de.tbag.gbd.potions.PotionsType;
import de.tbag.gbd.combat.Kampf;
import de.tbag.gbd.player.Spieler;
import de.tbag.gbd.potions.Potion;
import de.tbag.gbd.AdventureGame;

import java.util.Scanner;

/**
 * @author Samuel Ratzel | Lukas Knappich | [UR NAME]
 * @version 1.0
 * @since 28.02.24
 */
//nicht bearbeiten start
public class Game {

    String spielerEingabe;

    private AdventureGame game;
    private Kampf combat;
    public String playerName = "";
    private static Enemy enemy;
    private static Potion potions;
    private static PotionsType healSize;
    Scanner inputScanner = new Scanner(System.in);
    Spieler player;
    Shop shop;
    Debug debug;
    public Game(AdventureGame adventureGame) {
        this.game = adventureGame;
        this.combat = new Kampf(adventureGame);
        this.debug = new Debug();
        this.player = new Spieler(playerName, 100, 10, 3, game);
        this.shop = new Shop(player,3, inputScanner, game);
    }
    //nicht bearbeiten Ende



    //hier die Waffen definieren



    //hier die Tränke definieren



    //hier die Gegner definieren



    public void start(String playerName) throws InterruptedException {

        this.playerName = playerName;
        player.setName(playerName);
        player.showStats();

        //Am besten definierst du hier nochmal die Richtungen. Dies ist später dann einfacher zu programmieren
        String links = "links";
        String rechts = "rechts";
        String geradeaus = "geradeaus";
        String zurück = "zurück";
       //hier die game logic


        game.show("Hallo " + playerName);

        game.show("Du stehst vor einer Kreuzung");

        /**
         * Beispiel für eine Richtungsabfrage.
         * Dies kann mit minimal einer Richtung bis "unendlich" stattfinden.
         * alternativ kann dies auch über ein "switch case" gelöst werden.
         *
         * Am besten leitest du den Nutzer davor noch über ein game.show("")
         * in die Situation ein
         *
         * Ausgabe:
         *
         * Du kannst nach: links, rechts, geradeaus
         * Wohin willst du gehen
         */

        String richtung = game.richtungsOptionen(links, rechts, geradeaus);
        if (links.equals(richtung)) {
            // Handle left direction
            game.show("Du gehst nach " + richtung );

        } else if (rechts.equals(richtung)) {
            // Handle right direction
            game.show("Du gehst nach " + richtung );

        } else if (geradeaus.equals(richtung)) {
            // Handle forward direction
            game.show("Du gehst nach " + richtung );

        }


        /**
         * Beispiel für eine Abfrage nach einer Antwort:
         *
         * Dies funktioniert genau gleich wie die Richtungsoptionen,
         * printed jedoch anderes Feedback an den Nutzer
         *
         * Am besten leitest du den Nutzer davor noch über ein game.show("")
         * in die Situation ein
         *
         * Ausgabe:
         * Du hast folgende Antowrtmöglichkeiten: ja, nein, weiß ich nicht
         * Was willst du machen?
         */


        String antwort = game.antwortMöglichkeiten("ja", "nein", "weiß ich nicht");
        if ("ja".equals(antwort)){
            game.show("NICE!!!!");
        } else if ("nein".equals(antwort)) {
            game.show("Aber warum denn nicht");

        } else {
            game.show("Dann mach halt irgendwas :(");
        }


    }
}