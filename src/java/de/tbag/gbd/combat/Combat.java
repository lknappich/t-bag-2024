package de.tbag.gbd.combat;

import de.tbag.gbd.AdventureGame;
import de.tbag.gbd.BigTexts;
import de.tbag.gbd.cosmetic.ConsoleColors;
import de.tbag.gbd.player.Player;
import de.tbag.gbd.potions.Potion;
import de.tbag.gbd.potions.PotionsType;

/**
 * @author Lukas Knappich | Samuel Ratzel
 * @version 1.0
 * @since 28.02.24
 */

public class Combat {
    private static AdventureGame game;
    private static Potion potion;
    private static Player player;

    public Combat(AdventureGame adventureGame) {
        this.game = adventureGame;
    }

    public static void engageInCombat(Player player, Enemy enemy) throws InterruptedException {

        BigTexts bigTexts = new BigTexts();
        bigTexts.startBattle();

        System.out.println("A wild " + enemy.getName() + " appears!");

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            game.show(player.getName() + "'s turn:");
            game.show(ConsoleColors.GREEN + "1."+ ConsoleColors.RESET +" Attack with a weapon");
            game.show(ConsoleColors.YELLOW + "2."+ ConsoleColors.RESET +" Heal with a potion");
            game.show(ConsoleColors.RED + "3."+ ConsoleColors.RESET + " Run away");

            String choiceAsString = game.ask("Enter the number of the action you want to perform:");
            switch (choiceAsString) {
                case "1":
                    playerAttack(player, enemy);
                    break;
                case "2":
                    playerHeal(player);
                    break;
                case "3":
                    game.show("You run away from the battle!");
                    return;
                default:
                    game.show("Invalid choice. Please try again.");
                    break;
            }

            if (enemy.getHealth() <= 0) {
                player.addMoney((int) (enemy.getMaxHealth()/10));
                game.show("The " + enemy.getName() + " has been defeated and you earned " + player.getMoney() + " Money");
                game.show("You now have " + player.getMoney() + " Money");
                game.wait(2);
                break;
            }

            enemyActionDecision(player, enemy);
            game.wait(2);

            if (player.getHealth() <= 0) {
                game.show(player.getName() + " has been defeated!");
                game.wait(2);
                break;
            }
        }
    }

    public static void playerAttack(Player player, Enemy enemy) {
       try{ player.displayWeapons();
        String weaponChoice = game.ask("Enter the number of the weapon to attack with:");
        Weapon selectedWeapon = player.getWeapons().get(Integer.parseInt(weaponChoice) - 1);
        player.equipWeapon(selectedWeapon);
        int baseDamage = (int) (Math.random() * (selectedWeapon.getMaxDamage() - selectedWeapon.getMinDamage() + 1)) + selectedWeapon.getMinDamage();
        double critRoll = Math.random();
        int playerDamage;

        if (critRoll <= selectedWeapon.getCritChance()) {
            playerDamage = baseDamage + selectedWeapon.getCritDamage();
        } else {
            playerDamage = baseDamage;
        }

        enemy.takeDamage(playerDamage);
        game.show(player.getName() + " hits the " + enemy.getName() + " for " + playerDamage + " damage!");}
       catch (Exception e){
           System.out.println("Invalid choice. Please try again.");
       }
    }

    private static void enemyActionDecision(Player player, Enemy enemy) {
        double healthPercentage = (double) enemy.getHealth() / enemy.getMaxHealth() * 100;
        double random = Math.random() * 100;

        if (enemy.getAmountHealingPotions() == 0) {
            enemyAttack(player, enemy);
        } else {
            if (healthPercentage > 50) {
                if (random < 25) {
                    enemyHeal(enemy);
                } else {
                    enemyAttack(player, enemy);
                }
            } else if (healthPercentage <= 50 && healthPercentage > 1) {
                if (random < 50) {
                    enemyHeal(enemy);
                } else {
                    enemyAttack(player, enemy);
                }
            } else {
                if (random < 45) {
                    System.out.println("The enemy considers escaping!");
                    if (Math.random() < 0.1) {
                        System.out.println("The enemy successfully runs away!");
                        // You may want to end the combat loop or take appropriate action
                    } else {
                        System.out.println("The enemy decides to stay and fight.");
                        enemyAttack(player, enemy);
                    }
                } else {
                    enemyHeal(enemy);
                }
            }
        }
    }

    private static void enemyAttack(Player player, Enemy enemy){
        if (enemy.getWeapon() == null) {
            System.out.println("The enemy attacks with bare hands!");
            double damage = (int) (Math.random() * 10) + 1; // Bare hands attack example
            player.takeDamage(damage);
            game.show("The enemy hits " + player.getName() + " for " + damage + " damage!");
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

            player.takeDamage(enemyDamage);
            game.show("The enemy hits " + player.getName() + " for " + enemyDamage + " damage with " + enemyWeapon.getName() + "!");
        }
    }

    private static void playerHeal(Player player) {
        player.displayPotions();
        int potionChoice = Integer.parseInt(game.ask("Enter the number of the potion to heal with:"));
        Potion selectedPotion = player.getPotions().get(potionChoice - 1);
        System.out.println("Selected Potion" + selectedPotion);
        player.equipPotion(selectedPotion);
        System.out.println(ConsoleColors.RED + "equipped potion" + ConsoleColors.RESET);

        double playerMaxHealth = player.getMaxHealth();
        double amount = 0;
        PotionsType potionsType = selectedPotion.getPotionsType();
        switch (potionsType){
            case LARGE_POT -> amount = playerMaxHealth;
            case MEDIUM_POT -> amount = playerMaxHealth * 0.5;
            case SMALL_POT -> amount = playerMaxHealth * 0.25;
        }
        double currentplayerHealth = player.getHealth();
        double newPlayerHealth = currentplayerHealth + amount;

        if(newPlayerHealth > playerMaxHealth){
            newPlayerHealth = playerMaxHealth;
        }

        player.setHealth(newPlayerHealth);
        player.removePotion(selectedPotion);
        System.out.println("You healed yourself for " + amount + " !");

        game.show(player.getName() + " heals with " + selectedPotion.getName());
    }

    public static void playerStrength(Player player){
        player.displayPotions();
        int potionChoice = Integer.parseInt(game.ask("Enter the number of the potion to heal with:"));
        Potion selectedPotion = player.getPotions().get(potionChoice - 1);
        System.out.println("Selected Potion" + selectedPotion);
        player.equipPotion(selectedPotion);
        System.out.println(ConsoleColors.RED + "equipped potion" + ConsoleColors.RESET);
        double amountOfStrength = 0;
        PotionsType potionsType = selectedPotion.getPotionsType();



    }

    private static void enemyHeal(Enemy enemy){
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

        System.out.println(enemy.getName() + " healed for " + amount + " hp!");

    }

}