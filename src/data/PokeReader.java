/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import entity.category.Category;
import entity.category.TypeContainer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class PokeReader {

    private final List<Category> categories = new ArrayList();
    private final LinkedList<String> pokemonNames = new LinkedList();
    private static final String POKEMON_FILE_NAME_PATH = "src/resource/pokemon.txt";
    private static final String POKEMON_FILE_CATEGORY_PATH = "src/resource/pokemon_categories.json";
    private static PokeReader instance;

    private PokeReader() throws PokeException {
        readResources();
    }

    public static PokeReader getInstance() throws PokeException {
        if (instance == null) {
            instance = new PokeReader();
        }
        return instance;
    }

    public LinkedList<String> getPokemonNames() {
        return this.pokemonNames;
    }

    public List<Category> getCategories() {
        return categories;
    }

    private void readResources() throws PokeException {
        try {
            pokemonNames.addAll(Files
                    .readAllLines(Paths.get(POKEMON_FILE_NAME_PATH),
                            Charset.forName("ISO-8859-1")));
            readPokemonCategories();
        } catch (IOException ex) {
            throw new PokeException("(Error when try to read pokemon resources)" + ex);
        }
    }
    
    private void readPokemonCategories() throws PokeException {
        try {
            var path = Paths.get(POKEMON_FILE_CATEGORY_PATH).toFile().getPath();
            var gson = new GsonBuilder().create();
            var reader = new JsonReader(new FileReader(path));
            TypeContainer typeContainer = gson.fromJson(reader, TypeContainer.class);
            categories.add(typeContainer.getAir());
            categories.add(typeContainer.getLand());
            categories.add(typeContainer.getWater());
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            throw new PokeException("(Error when try to parse pokemon resources)" + e);
        }
    }
}
