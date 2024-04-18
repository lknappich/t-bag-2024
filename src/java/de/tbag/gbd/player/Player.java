package de.tbag.gbd.player;

import de.tbag.gbd.combat.Weapon;
import de.tbag.gbd.cosmetic.ConsoleColors;
import de.tbag.gbd.debug.Debug;
import de.tbag.gbd.misc.ShopItem;
import de.tbag.gbd.potions.Potion;
import de.tbag.gbd.AdventureGame;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Lukas Knappich | Samuel Ratzel
 * @version 1.0
 * @since 28.02.24
 */

public class Player {
    private String name;
    private int money;
    private double health;
    private double maxHealth;
    private int maxWeapons;
    private int maxPotions;
    private List<Weapon> weapons;
    private List<Potion> potions;
    private Weapon equippedWeapon;
    private Potion equippedPotion;
    private Debug debug = new Debug();
    private AdventureGame game;



    public Player(String name, double health, int maxWeapons, int maxPotions, AdventureGame game) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.maxWeapons = maxWeapons;
        this.maxPotions = maxPotions;
        this.weapons = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.game = game;

    }

    public void addMoney(int amountToAdd){
        money = money + amountToAdd;
    }

    public void showStats(){
        System.out.println( ConsoleColors.GREEN + "Name: " + this.name
                + ConsoleColors.RED + " | Health: " + health + ConsoleColors.YELLOW + " | Money: " + money + ConsoleColors.RESET);
    }

    public void addPotion(Potion potion){
        if (potions.size() < maxPotions) {
            potions.add(potion);
        }else {
            System.out.println("Cannot cary more Potions");
        }
    }
    public void removeItem(ShopItem item) {
        System.out.println("Before removing a weapon: " + weapons.size() + "/" + maxWeapons);
        weapons.remove(item);
        System.out.println("After removing a weapon: " + weapons.size() + "/" + maxWeapons);
    }

    public void removePotion(Potion potion){
        potions.remove(potion);
    }

    public void addWeapon(Weapon weapon) {
        debug.message("Before adding a weapon: " + weapons.size() + "/" + maxWeapons);
        if (weapons.size() < maxWeapons) {
            weapons.add(weapon);
        } else {
            System.out.println("Cannot carry more weapons.");
        }
        debug.message("After adding a weapon: " + weapons.size() + "/" + maxWeapons);
    }

    public void displayWeapons() {
        System.out.println("Weapons in inventory:");
        int i = 1;
        for (Weapon weapon : weapons) {
            System.out.println( i +". " + weapon.getName() + " | Type: " + weapon.getType() + " | Damage: " + weapon.getMinDamage() + " - " + weapon.getMaxDamage() +
                    " | Critical Damage: " + weapon.getCritDamage() + " | Critical Chance: " + weapon.getCritChance());
            i++;
        }
    }

    public void displayPotions(){
        System.out.println("Potions in inventory: ");
        int i = 1;
        for (Potion potions : potions) {
            System.out.println(i + ". " + potions.getName() + " | Type: " + potions.getPotionsType() + " | Heal: " + potions.getHeal() + ".");
        }

    }

    public void takeDamage(double damage) {
        health = health - damage;

    }

    public void removeMoney(int amount) {
        this.money -= amount;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Potion getEquippedPotion(){
     return equippedPotion;
    }
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    public void equipPotion(Potion potion){
        this.equippedPotion = potion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWeapons() {
        return maxWeapons;
    }

    public void setMaxWeapons(int maxWeapons) {
        this.maxWeapons = maxWeapons;
    }

    public int getMaxPotions() {
        return maxPotions;
    }

    public void setMaxPotions(int maxPotions) {
        this.maxPotions = maxPotions;
    }

    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void setEquippedPotions(Potion equippedPotion){
        this.equippedPotion = equippedPotion;
    }


}


