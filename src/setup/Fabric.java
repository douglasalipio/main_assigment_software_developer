/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import entity.Pokemon;
import entity.Air;
import entity.Assistant;
import entity.Land;
import entity.Room;
import entity.Water;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author hal-9000
 */
public class Fabric {

    private static final int POKEMON_SIZE = 80;
    private static final int ROOMS_SIZE = 100;
    private static final int ASSISTANTS_SIZE = 20;
    private final DataSet dataSet = DataSet.instance();
    private final LinkedList<Pokemon> pokemons = new LinkedList();
    private final LinkedList<Assistant> assistants = new LinkedList();
    private final LinkedList<Room> rooms = new LinkedList();
    private static Fabric instance;

    private Fabric() throws PokeException {
        buildPokemons();
        buildAssistants();
        buildRooms();
        instance = this;
    }

    public static Fabric instance() throws PokeException {
        if (instance == null) {
            return new Fabric();
        }
        return instance;
    }

    private LinkedList<Pokemon> buildPokemons() throws PokeException {
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
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    private LinkedList<Assistant> buildAssistants() throws PokeException {
        for (int i = 0; i < ASSISTANTS_SIZE; i++) {
            var assistant = new Assistant(dataSet.assistantName(),
                    dataSet.assistentLevel());
            var types = dataSet.getAssistentType();
            assistant.addTypes(types);
            var guest = assistantGuests(types[new Random().nextInt(2)]);
            var res = assistant.addGuests(guest);
            if (res) {
                pokemons.remove(guest);
            }
            assistants.add(assistant);
        }

        return assistants;
    }

    private Pokemon assistantGuests(String assistantType) {
        var guest = this.pokemons
                .stream()
                .filter(pokemon -> pokemon.getType().equalsIgnoreCase(assistantType))
                .findAny()
                .orElse(null);
        return guest;
    }

    private LinkedList<Room> buildRooms() {
        for (Assistant assistant : assistants) {
            var room = new Room(dataSet.getResistanceRoom());
            for (Pokemon pokemon : assistant.getGuests()) {
                if (pokemon != null) {
                    room.accept(pokemon);
                    room.setAssistantId(assistant.getId());
                }
            }
            rooms.add(room);
        }

        return rooms;
    }

    public LinkedList<Pokemon> getPokemons() {
        return pokemons;
    }

    public LinkedList<Assistant> getAssistants() {
        return assistants;
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }
}
