/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.PokemonReader.Type.POKEMON_NAME;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 *
 * @author hal-9000
 */
public class PokemonReader {

    private final LinkedList<String> pokemonTypes = new LinkedList();
    private final LinkedList<String> pokemonNames = new LinkedList();
    private static final String POKEMON_FILE_NAME_PATH = "src/resource/poke_types.txt";
    private static final String POKEMON_FILE_TYPE_PATH = "src/resource/pokemon.txt";
    private static PokemonReader instance;

    private PokemonReader(Type type) throws PokemonException {
        readFile(type);
    }

    public static PokemonReader getInstance(Type type) throws PokemonException {
        if (instance == null) {
            instance = new PokemonReader(type);
        }
        return instance;
    }

    public LinkedList<String> getPokemonNames() {
        return this.pokemonNames;
    }

    public LinkedList<String> getPokemonTypes() {
        return pokemonTypes;
    }

    private void readFile(Type type) throws PokemonException {
        try {
            if (type == POKEMON_NAME) {
                pokemonNames.addAll(Files
                        .readAllLines(Paths.get(POKEMON_FILE_NAME_PATH),
                                Charset.forName("ISO-8859-1")));
            } else {
                pokemonTypes.addAll(Files
                        .readAllLines(Paths.get(POKEMON_FILE_TYPE_PATH),
                                Charset.forName("ISO-8859-1")));
            }
        } catch (IOException ex) {
            throw new PokemonException("(Erro when try to read pokemon typde)" + ex);
        }
    }

    public enum Type {
        POKEMON_NAME(),
        POKEMON_TYPE()
    }
}
