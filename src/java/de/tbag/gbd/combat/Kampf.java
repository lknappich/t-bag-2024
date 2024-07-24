package de.tbag.gbd.combat;

import de.tbag.gbd.AdventureGame;
import de.tbag.gbd.BigTexts;
import de.tbag.gbd.cosmetic.Colors;
import de.tbag.gbd.player.Spieler;
import de.tbag.gbd.potions.Potion;
import de.tbag.gbd.potions.PotionsType;

import java.util.Random;

/**
 * @author Lukas Knappich | Samuel Ratzel
 * @version 1.0
 * @since 28.02.24
 */

public class Kampf {
    private static AdventureGame game;
    private static Potion potion;
    private static Spieler spieler;

    public Kampf(AdventureGame adventureGame) {
        this.game = adventureGame;
    }

    public static void starte(Spieler spieler, Enemy enemy) throws InterruptedException {

        BigTexts bigTexts = new BigTexts();
        bigTexts.startBattle();

        String[] encounterMessages = {
                "Vor dir steht ein wilder %s!",
                "Ein wütender %s springt aus dem Unterholz!",
                "Ein schattenhafter %s erscheint vor dir!",
                "Ein bedrohlicher %s tritt aus der Dunkelheit hervor!",
                "Überraschend taucht ein %s vor dir auf!",
                "Ein %s herausfordert dich zum Kampf!",
                "Mit einem lauten Kreischen erscheint ein %s!",
                "Ein %s schleicht sich aus den Schatten an!",
                "Achtung! Ein %s ist aufgetaucht!",
                "Die Legende spricht von einem %s, und jetzt ist er hier!"
        };

        // Erstelle ein Random Objekt
        Random random = new Random();

        int index = random.nextInt(encounterMessages.length);
        String randomMessage = encounterMessages[index];

        // Ausgabe der zufälligen Nachricht
        System.out.println(String.format(randomMessage, enemy.getName()));

        while (spieler.getHealth() > 0 && enemy.getHealth() > 0) {
            game.show(spieler.getName() + "'s turn:");
            game.show(Colors.GREEN + "1."+ Colors.RESET +" Attack with a weapon");
            game.show(Colors.YELLOW + "2."+ Colors.RESET +" Heal with a potion");
            game.show(Colors.RED + "3."+ Colors.RESET + " Run away");

            String choiceAsString = game.ask("Enter the number of the action you want to perform:");
            switch (choiceAsString) {
                case "1":
                    playerAttack(spieler, enemy);
                    break;
                case "2":
                    heileSpieler(spieler);
                    break;
                case "3":
                    game.show("You run away from the battle!");
                    return;
                default:
                    game.show("Invalid choice. Please try again.");
                    break;
            }

            if (enemy.getHealth() <= 0) {
                spieler.addMoney((int) (enemy.getMaxHealth()/10));
                game.show(enemy.getName() + " wurde besiegt und du hast " + spieler.getMoney() + " Gold bekommen");
                game.show("Du hast nun " + spieler.getMoney() + " Gold");
                game.wait(2);
                break;
            }

            enemyActionDecision(spieler, enemy);
            game.wait(2);

            if (spieler.getHealth() <= 0) {
                game.show(spieler.getName() + " wurde besiegt.");
                game.wait(2);
                break;
            }
        }
    }

    public static void playerAttack(Spieler spieler, Enemy enemy) {
       try{ spieler.displayWeapons();
        String weaponChoice = game.ask("Gib die Nummer der Waffe ein, mit der du attackieren willst.");
        Weapon selectedWeapon = spieler.getWeapons().get(Integer.parseInt(weaponChoice) - 1);
        spieler.equipWeapon(selectedWeapon);
        int baseDamage = (int) (Math.random() * (selectedWeapon.getMaxDamage() - selectedWeapon.getMinDamage() + 1)) + selectedWeapon.getMinDamage();
        double critRoll = Math.random();
        int playerDamage;

        if (critRoll <= selectedWeapon.getCritChance()) {
            playerDamage = baseDamage + selectedWeapon.getCritDamage();
        } else {
            playerDamage = baseDamage;
        }

        enemy.takeDamage(playerDamage);
        game.show(spieler.getName() + " trifft " + enemy.getName() + " mit " + playerDamage + " Schaden!");}
       catch (Exception e){
           System.out.println("Falsche eingabe. Bitte nocheinmal.");
       }
    }

    private static void enemyActionDecision(Spieler spieler, Enemy enemy) {
        double healthPercentage = (double) enemy.getHealth() / enemy.getMaxHealth() * 100;
        double random = Math.random() * 100;

        if (enemy.getAmountHealingPotions() == 0) {
            enemyAttack(spieler, enemy);
        } else {
            if (healthPercentage > 50) {
                if (random < 25) {
                    heileGegner(enemy);
                } else {
                    enemyAttack(spieler, enemy);
                }
            } else if (healthPercentage <= 50 && healthPercentage > 1) {
                if (random < 50) {
                    heileGegner(enemy);
                } else {
                    enemyAttack(spieler, enemy);
                }
            } else {
                if (random < 45) {
                    System.out.println(enemy.getName() + " überlegt abzuhauen");
                    if (Math.random() < 0.1) {
                        System.out.println(enemy.getName() + "ist erfolgreich abgehauen");
                        // You may want to end the combat loop or take appropriate action
                    } else {
                        System.out.println(enemy.getName() + " ist nicht feige und kämpft weiter");
                        enemyAttack(spieler, enemy);
                    }
                } else {
                    heileGegner(enemy);
                }
            }
        }
    }

    private static void enemyAttack(Spieler spieler, Enemy enemy){
        if (enemy.getWeapon() == null) {
            System.out.println(enemy.getName() + " attackiert mit den Händen");
            double damage = (int) (Math.random() * 10) + 1; // Bare hands attack example
            spieler.takeDamage(damage);
            game.show(enemy.getName() + " hits " + spieler.getName() + " mit " + damage + " Schaden!");
        } else {
            Weapon enemyWeapon = enemy.getWeapon();
            int baseDamage = (int) (Math.random() * (enemyWeapon.getMaxDamage() - enemyWeapon.getMinDamage() + 1)) + enemyWeapon.getMinDamage();
            double critRoll = Math.random();
            int enemyDamage;

            if (critRoll <= enemyWeapon.getCritChance()) {
                enemyDamage = baseDamage + enemyWeapon.getCritDamage();
            } else {
                enemyDamage = baseDamage;
            }

            spieler.takeDamage(enemyDamage);
            game.show(enemy.getName() + " hits " + spieler.getName() + " mit " + enemyDamage + " hp Schaden mit " + enemyWeapon.getName() + "!");
        }
    }

    private static void heileSpieler(Spieler spieler) {
        spieler.displayPotions();
        int potionChoice = Integer.parseInt(game.ask("Gib die nummer des Tranks ein, mit dem du dich heilen möchtest:"));
        Potion selectedPotion = spieler.getPotions().get(potionChoice - 1);
        System.out.println("Ausgewählter Trank: " + selectedPotion);
        spieler.equipPotion(selectedPotion);
        System.out.println(Colors.RED + "ausgewählter Trank" + Colors.RESET);

        double playerMaxHealth = spieler.getMaxHealth();
        double amount = 0;
        PotionsType potionsType = selectedPotion.getPotionsType();
        switch (potionsType){
            case LARGE_POT -> amount = playerMaxHealth;
            case MEDIUM_POT -> amount = playerMaxHealth * 0.5;
            case SMALL_POT -> amount = playerMaxHealth * 0.25;
        }
        double currentplayerHealth = spieler.getHealth();
        double newPlayerHealth = currentplayerHealth + amount;

        if(newPlayerHealth > playerMaxHealth){
            newPlayerHealth = playerMaxHealth;
        }

        spieler.setHealth(newPlayerHealth);
        spieler.removePotion(selectedPotion);
        System.out.println("Du hast dich um " + amount + "hp geheilt!");

        game.show(spieler.getName() + " heilt sich mit " + selectedPotion.getName());
    }

    private static void heileGegner(Enemy enemy){
        int potionAmount = enemy.getAmountHealingPotions();
        double enemyMaxHealt = enemy.getMaxHealth();
        double amount = 0;
        double random = Math.random();

        PotionsType potionsType;
        if(random < 55){
            potionsType = PotionsType.SMALL_POT;
            amount = enemyMaxHealt * 0.25;
        } else if (random < 90) {
            potionsType = PotionsType.MEDIUM_POT;
            amount = enemyMaxHealt * 0.5;
        } else {
            potionsType = PotionsType.LARGE_POT;
            amount = enemyMaxHealt;
        }


        double currentEnemyHP = enemy.getHealth();
        double newEnemyHP = currentEnemyHP + amount;

        if (newEnemyHP > enemyMaxHealt){
            newEnemyHP = enemyMaxHealt;
        }
        enemy.setHealth(newEnemyHP);

        System.out.println(enemy.getName() + " hat sich um " + amount + " hp geheilt!");

    }

}