/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author hal-9000
 */
public class DataSet {

    private final Random random = new Random();

    public int attackRate() {
        int[] rates = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    public int speedrate() {
        int[] rates = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    public int pokemonLevel() {
        int[] rates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    public int resistencekRate() {
        int[] rates = {3, 4, 5, 6, 7};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    public int guestLevel() {
        int[] rates = {1, 2, 3, 4, 5, 6};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

}
