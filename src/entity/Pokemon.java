package entity;

import java.util.UUID;
import utils.ColorUtils;
import utils.Generator;

/**
 * Class who represent a Pokemon
 *
 * @author hal-9000
 */
public class Pokemon {

    private final long id;
    private final String name;
    private final int specialAttack;
    private final int speedRate;
    private final int level;
    private final Category category;
    private final String type;

    /**
     * Creating a Pokemon object.
     *
     * @param name
     * @param specialAttack
     * @param speedRate
     * @param level
     * @param category
     * @param type
     */
    public Pokemon(String name,
            int specialAttack,
            int speedRate,
            int level,
            Category category,
            String type) {
        this.id = Generator.instance().createID();
        this.name = name;
        this.specialAttack = specialAttack;
        this.speedRate = speedRate;
        this.level = level;
        this.category = category;
        this.type = type;
    }

    /**
     * Getting category.
     *
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Getting name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getting special attack.
     *
     * @return
     */
    public int getSpecialAttack() {
        return specialAttack;
    }

    /**
     * Getting speed rate.
     *
     * @return
     */
    public int getSpeedRate() {
        return speedRate;
    }

    /**
     * Getting level.
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getting type.
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Getting id.
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Printing Pokemon.
     *
     * @return
     */
    @Override
    public String toString() {
        return "" + ColorUtils.ANSI_GREEN + "Pokemon" + "\n"
                + "\t" + ColorUtils.ANSI_RED + "ID = " + ColorUtils.ANSI_WHITE + "" + id + "\n"
                + "\t" + ColorUtils.ANSI_RED + "name = " + ColorUtils.ANSI_WHITE + "" + name + "\n"
                + "\t" + ColorUtils.ANSI_RED + "speedRate = " + ColorUtils.ANSI_WHITE + "" + speedRate + "\n"
                + "\t" + ColorUtils.ANSI_RED + "specialAttack = " + ColorUtils.ANSI_WHITE + "" + specialAttack + "\n"
                + "\t" + ColorUtils.ANSI_RED + "level = " + ColorUtils.ANSI_WHITE + "" + level + "\n"
                + "\t" + ColorUtils.ANSI_RED + "category = " + ColorUtils.ANSI_WHITE + "" + category.getClass().getName().replace("entity.", "") + "\n"
                + "\t" + ColorUtils.ANSI_RED + "type = " + ColorUtils.ANSI_WHITE + "" + type + "\n";
    }
}
