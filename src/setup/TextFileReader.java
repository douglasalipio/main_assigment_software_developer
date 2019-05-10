/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import entity.Category;
import entity.TypeContainer;
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
public class TextFileReader {

    private final List<Category> categories = new ArrayList();
    private final LinkedList<String> pokemonNames = new LinkedList();
    private final LinkedList<String> assistantNames = new LinkedList();
    private final LinkedList<String> allTypes = new LinkedList();
    private static final String ASSISTANT_NAME_PATH = "src/resource/assistant_names.txt";
    private static final String POKEMON_NAME_PATH = "src/resource/pokemon_names.txt";
    private static final String POKEMON_CATEGORY_PATH = "src/resource/pokemon_categories.json";
    private static TextFileReader instance;

    private TextFileReader() throws PokeException {
        readResources();
    }

    public static TextFileReader getInstance() throws PokeException {
        if (instance == null) {
            instance = new TextFileReader();
        }
        return instance;
    }

    public LinkedList<String> getPokemonNames() {
        return this.pokemonNames;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public LinkedList<String> getAssistantNames() {
        return assistantNames;
    }

    private void readResources() throws PokeException {
        try {
            pokemonNames.addAll(Files
                    .readAllLines(Paths.get(POKEMON_NAME_PATH),
                            Charset.forName("ISO-8859-1")));

            assistantNames.addAll(Files
                    .readAllLines(Paths.get(ASSISTANT_NAME_PATH),
                            Charset.forName("UTF-8")));
            readPokemonCategories();
        } catch (IOException ex) {
            throw new PokeException("(Error when try to read pokemon resources)" + ex);
        }
    }

    private void readPokemonCategories() throws PokeException {
        try {

            var path = Paths.get(POKEMON_CATEGORY_PATH).toFile().getPath();
            var gson = new GsonBuilder().create();
            var reader = new JsonReader(new FileReader(path));
            TypeContainer stamp = gson.fromJson(reader, TypeContainer.class);

            categories.add(stamp.getAir());
            categories.add(stamp.getLand());
            categories.add(stamp.getWater());

            allTypes.addAll(stamp.getAir().getTypes());
            allTypes.addAll(stamp.getLand().getTypes());
            allTypes.addAll(stamp.getWater().getTypes());

        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            throw new PokeException("(Error when try to parse pokemon resources)" + e);
        }
    }

    public List<String> allPokemonTypes() {
        return allTypes;
    }
}
