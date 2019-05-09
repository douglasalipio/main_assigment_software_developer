/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.category.Category;
import utils.ColorUtils;

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
        return "" + ColorUtils.ANSI_GREEN + "Pokemon" + "\n"
                + "\t" + ColorUtils.ANSI_RED + "name = " + ColorUtils.ANSI_WHITE + "" + name + "\n"
                + "\t" + ColorUtils.ANSI_RED + "speedRate = " + ColorUtils.ANSI_WHITE + "" + speedRate + "\n"
                + "\t" + ColorUtils.ANSI_RED + "level = " + ColorUtils.ANSI_WHITE + "" + level + "\n"
                + "\t" + ColorUtils.ANSI_RED + "category = " + ColorUtils.ANSI_WHITE + "" + category + "\n"
                + "\t" + ColorUtils.ANSI_RED + "type = " + ColorUtils.ANSI_WHITE + "" + type + "\n";
    }
}
