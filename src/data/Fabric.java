/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Pokemon;
import entity.category.Air;
import entity.category.Category;
import entity.category.Land;
import entity.category.Water;
import java.util.LinkedList;

/**
 *
 * @author hal-9000
 */
public class Fabric {

    private static final int POKEMON_SIZE = 80;
    private static final int ROOMS = 100;
    private final DataSet dataSet = DataSet.instance();

    public LinkedList<Pokemon> buildPokemons() throws PokeException {
        var pokemonContainer = new LinkedList<Pokemon>();

        for (int i = 0; i < POKEMON_SIZE; i++) {
            Pokemon pokemon = null;
            if (i < POKEMON_SIZE / 3) {
                var landCategory = filterLand();
                pokemon = new Pokemon(dataSet.pokemonName(),
                        dataSet.attackRate(),
                        dataSet.speedRate(),
                        dataSet.pokemonLevel(),
                        landCategory,
                        dataSet.getPokemonType(landCategory));
            } else if (i > POKEMON_SIZE / 3 && i < POKEMON_SIZE / 2) {
                var airCategory = filterAir();
                pokemon = new Pokemon(dataSet.pokemonName(),
                        dataSet.attackRate(),
                        dataSet.speedRate(),
                        dataSet.pokemonLevel(),
                        airCategory,
                        dataSet.getPokemonType(airCategory));
            } else {
                var waterCategory = filterWater();
                pokemon = new Pokemon(dataSet.pokemonName(),
                        dataSet.attackRate(),
                        dataSet.speedRate(),
                        dataSet.pokemonLevel(),
                        waterCategory,
                        dataSet.getPokemonType(waterCategory));
            }
            pokemonContainer.add(pokemon);
        }
        return pokemonContainer;
    }

    private Category filterLand() throws PokeException {
        var category = PokeReader.getInstance().getCategories()
                .stream()
                .filter(it -> it instanceof Land)
                .findFirst()
                .orElse(null);
        return category;
    }

    private Category filterWater() throws PokeException {
        var category = PokeReader.getInstance().getCategories()
                .stream()
                .filter(it -> it instanceof Water)
                .findFirst()
                .orElse(null);
        return category;
    }

    private Category filterAir() throws PokeException {
        var air = PokeReader.getInstance().getCategories()
                .stream()
                .filter(it -> it instanceof Air)
                .findFirst()
                .orElse(null);
        var category = (Category) air;
        return category;
    }

    public LinkedList<Pokemon> buildRooms() {
        return null;
    }
}
