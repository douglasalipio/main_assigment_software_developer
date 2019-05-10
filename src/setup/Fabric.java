/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import entity.Pokemon;
import entity.Air;
import entity.Assistant;
import entity.Category;
import entity.Land;
import entity.Room;
import entity.Water;
import java.util.LinkedList;

/**
 *
 * @author hal-9000
 */
public class Fabric {

    private static final int POKEMON_SIZE = 80;
    private static final int ROOMS_SIZE = 100;
    private static final int ASSISTANTS_SIZE = 20;
    private final DataSet dataSet = DataSet.instance();

    public LinkedList<Pokemon> buildPokemons() throws PokeException {
        var pokemonContainer = new LinkedList<Pokemon>();

        for (int i = 0; i < POKEMON_SIZE; i++) {
            Pokemon pokemon = null;
            if (i < POKEMON_SIZE / 3) {
                var landCategory = dataSet.filterLand();
                landCategory.set(new Land());
                pokemon = new Pokemon(dataSet.pokemonName(),
                        dataSet.attackRate(),
                        dataSet.speedRate(),
                        dataSet.pokemonLevel(),
                        landCategory,
                        dataSet.getPokemonType(landCategory));
            } else if (i > POKEMON_SIZE / 3 && i < POKEMON_SIZE / 2) {
                var airCategory = dataSet.filterAir();
                airCategory.set(new Air());
                pokemon = new Pokemon(dataSet.pokemonName(),
                        dataSet.attackRate(),
                        dataSet.speedRate(),
                        dataSet.pokemonLevel(),
                        airCategory,
                        dataSet.getPokemonType(airCategory));
            } else {
                var waterCategory = dataSet.filterWater();
                waterCategory.set(new Water());
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

    public LinkedList<Assistant> buildAssistants() throws PokeException {
        var assistants = new LinkedList<Assistant>();
        for (int i = 0; i < ASSISTANTS_SIZE; i++) {
            var assistant = new Assistant(dataSet.assistantName(),
                    dataSet.assistentLevel());
            var types = dataSet.getAssistentType();
            assistant.addTypes(types);
            assistants.add(assistant);
        }

        return assistants;
    }

    public LinkedList<Room> buildRooms() {
        var rooms = new LinkedList();
        for (int i = 0; i < ROOMS_SIZE; i++) {
            rooms.add(new Room(dataSet.getResistenceRoom()));
        }
        return rooms;
    }
}
