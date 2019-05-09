/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.category.Air;
import entity.category.Category;
import entity.category.Land;
import entity.category.Water;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hal-9000
 */
public class DataSet {

    private final Random random = new Random();
    private static DataSet instance;

    private DataSet() {

    }

    public static DataSet instance() {
        if (instance == null) {
            instance = new DataSet();
        }
        return instance;
    }

    public int attackRate() {
        int[] rates = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    public int speedRate() {
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

    public String getPokemonType(Category category) {
        if (category instanceof Air) {
            var air = ((Air) category);
            int airIndex = random.nextInt(air.getTypes().size());
            return air.getTypes().get(airIndex);

        } else if (category instanceof Water) {
            var water = ((Water) category);
            int airIndex = random.nextInt(water.getTypes().size());
            return water.getTypes().get(airIndex);

        } else {
            var land = ((Land) category);
            int landIndex = random.nextInt(land.getTypes().size());
            return land.getTypes().get(landIndex);
        }
    }

    public String pokemonName() throws PokeException {
        String name = null;
        var pokemonNames = PokeReader.getInstance().getPokemonNames();
        int nameIndex = random.nextInt(pokemonNames.size());
        while (name == null) {
            if (!pokemonNames.get(nameIndex).isEmpty()) {
                name = pokemonNames.get(nameIndex);
                pokemonNames.remove(pokemonNames.get(nameIndex));
            }
        }
        return name;
    }

}
