/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import entity.Air;
import entity.Category;
import entity.Land;
import entity.Water;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Data set class.
 *
 * @author hal-9000
 */
public class DataSet {

    private final Random random = new Random();
    private static DataSet instance;

    /**
     * Creating data set.
     */
    private DataSet() {

    }

    /**
     * Getting data set instance.
     *
     * @return
     */
    public static DataSet instance() {
        if (instance == null) {
            instance = new DataSet();
        }
        return instance;
    }

    /**
     * Generating attack rate randomly.
     *
     * @return
     */
    public int attackRate() {
        int[] rates = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    /**
     * Generating speed rate randomly.
     *
     * @return
     */
    public int speedRate() {
        int[] rates = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    /**
     * Generating level randomly.
     *
     * @return
     */
    public int pokemonLevel() {
        int[] rates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    /**
     * Generating resistance rate randomly.
     *
     * @return
     */
    public int resistancekRate() {
        int[] rates = {3, 4, 5, 6, 7};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    /**
     * Generating level randomly.
     *
     * @return
     */
    public int assistentLevel() {
        int[] rates = {1, 2, 3, 4, 5, 6};
        int rateIndex = random.nextInt(rates.length);
        return rates[rateIndex];
    }

    /**
     * Generating Pokemon type randomly.
     *
     * @return
     */
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
            Land land = ((Land) category);
            int landIndex = random.nextInt(land.getTypes().size());
            return land.getTypes().get(landIndex);
        }
    }

    /**
     * Generating resistance room randomly.
     *
     * @return
     */
    public int getResistanceRoom() {
        var max = 7;
        var min = 3 + 1;
        return random.nextInt(max) + min;
    }

    /**
     * Getting Pokemon names from file.
     *
     * @return
     */
    public String pokemonName() throws PokeException {
        String name = null;
        var pokemonNames = TextFileReader.getInstance().getPokemonNames();
        int nameIndex = random.nextInt(pokemonNames.size());
        while (name == null) {
            if (!pokemonNames.get(nameIndex).isEmpty()) {
                name = pokemonNames.get(nameIndex);
                pokemonNames.remove(pokemonNames.get(nameIndex));
            }
        }
        return name;
    }

    /**
     * Getting assistant name from file.
     *
     * @return
     * @throws PokeException
     */
    public String assistantName() throws PokeException {
        String name = null;
        var assistantNames = TextFileReader.getInstance().getAssistantNames();

        if (!assistantNames.isEmpty()) {
            int nameIndex = random.nextInt(assistantNames.size());
            while (name == null) {
                if (!assistantNames.get(nameIndex).isEmpty()) {
                    name = assistantNames.get(nameIndex);
                    assistantNames.remove(assistantNames.get(nameIndex));
                }
            }
        }

        return name;
    }

    /**
     * Getting assistant type from a JSON file.
     *
     * @return
     * @throws PokeException
     */
    public String[] getAssistentType() throws PokeException {
        List<String> types = new ArrayList();
        int count = 0;
        var allTypes = TextFileReader.getInstance().allPokemonTypes();
        var currentIndex = random.nextInt(allTypes.size());
        types.add(allTypes.get(currentIndex));
        while (count < 1) {
            var currentType = allTypes.get(random.nextInt(allTypes.size()));
            if (!currentType.equalsIgnoreCase(types.get(0))) {
                count++;
                types.add(currentType);
            }
        }
        return types
                .stream()
                .toArray(String[]::new);
    }

    /**
     * Filter category by Land.
     *
     * @return
     * @throws PokeException
     */
    public Category filterLand() throws PokeException {
        var category = TextFileReader.getInstance().getCategories()
                .stream()
                .filter(it -> it instanceof Land)
                .findFirst()
                .orElse(null);
        return category;
    }

    /**
     * Filter category by Water.
     *
     * @return
     * @throws PokeException
     */
    public Category filterWater() throws PokeException {
        var category = TextFileReader.getInstance().getCategories()
                .stream()
                .filter(it -> it instanceof Water)
                .findFirst()
                .orElse(null);
        return category;
    }

    /**
     * Filter category by Air.
     *
     * @return
     * @throws PokeException
     */
    public Category filterAir() throws PokeException {
        var category = TextFileReader.getInstance().getCategories()
                .stream()
                .filter(it -> it instanceof Air)
                .findFirst()
                .orElse(null);
        return category;
    }

}
