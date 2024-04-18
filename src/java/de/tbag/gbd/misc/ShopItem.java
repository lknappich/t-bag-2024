package de.tbag.gbd.misc;

import de.tbag.gbd.combat.Weapon;

/**
 * @author Samuel Ratzel | Lukas Knappich
 * @version 1.0
 * @since 29.02.24
 */

public class ShopItem {
    private int stock;
    private Weapon weapon;
    private int cost;

    public ShopItem(Weapon weapon, int cost, int stock) {
        this.weapon = weapon;
        this.cost = cost;
        this.stock = stock;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getCost() {
        return this.cost;
    }
    public String getName() {
        return this.weapon.getName();
    }

    public int getStock() {
        return this.stock;
    }

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        }
    }

}
