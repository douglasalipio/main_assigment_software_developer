/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author hal-9000
 */
public class Pokemon {

    private final String name;
    private final String type;
    private final int specialAttack;
    private final int speedRate;
    private final int level;
    private final Genetic genetic;

    public Pokemon(String name, String type,
            int specialAttack,
            int speedRate,
            int level,
            Genetic genetic) {

        this.genetic = genetic;
        this.name = name;
        this.type = type;
        this.specialAttack = specialAttack;
        this.speedRate = speedRate;
        this.level = level;
    }

    public Genetic getGenetic() {
        return genetic;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

}
