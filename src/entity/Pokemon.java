/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.category.Category;

/**
 *
 * @author hal-9000
 */
public class Pokemon {

    private final String name;
    private final int specialAttack;
    private final int speedRate;
    private final int level;
    private final Category category;
    private final String type;

    public Pokemon(String name,
            int specialAttack,
            int speedRate,
            int level,
            Category category,
            String type) {

        this.name = name;
        this.specialAttack = specialAttack;
        this.speedRate = speedRate;
        this.level = level;
        this.category = category;
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpeedRate() {
        return speedRate;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "name=" + name + ", "
                + "specialAttack=" + specialAttack + ","
                + "speedRate=" + speedRate + ", "
                + "level=" + level + ","
                + "Category=" + category + ","
                + "type=" + type + '}' + "\n";
    }
}
