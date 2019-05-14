package entity;

import setup.PokeException;
import java.util.ArrayList;
import java.util.List;
import utils.ColorUtils;
import utils.Generator;

/**
 * Class who represent a Personal assistant category
 *
 * @author hal-9000
 */
public class Assistant {

    private final long id;
    private final String name;
    private final int level;
    private final List<String> types = new ArrayList();
    private final List<Pokemon> guests = new ArrayList();
    private static final int LIMIT_GUEST = 5;
    private static final int LIMIT_TYPES = 2;

    /**
     * Creating a assistant.
     *
     * @param name of the assistant
     * @param level of the assistant.
     */
    public Assistant(String name, int level) {
        this.id = Generator.instance().createID();
        this.name = name;
        this.level = level;
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
     * Getting level
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getting all types from the assistant.
     *
     * @return
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * Getting guests.
     *
     * @return
     */
    public List<Pokemon> getGuests() {
        return guests;
    }

    /**
     * Getting ID.
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Adding types to the assistant.
     *
     * @param types
     * @throws PokeException
     */
    public void addTypes(String... types) throws PokeException {
        for (String type : types) {
            if (this.types.size() < LIMIT_TYPES) {
                this.types.add(type);
            } else {
                throw new PokeException("Only two types are allowed. Total types "
                        + "limit is" + LIMIT_TYPES);
            }
        }
    }

    /**
     * Adding guests to the assistant.
     *
     * @param guests
     * @return
     * @throws PokeException
     */
    public boolean addGuests(Pokemon... guests) throws PokeException {
        var res = false;
        for (Pokemon guest : guests) {
            if (this.guests.size() < LIMIT_GUEST) {
                this.guests.add(guest);
                res = true;
            } else {
                res = false;
                throw new PokeException("Only five types are allowed. Total guests "
                        + "limit is" + guests.length);
            }
        }
        return res;
    }

    /**
     * Printing assistant.
     *
     * @return
     */
    @Override
    public String toString() {
        return "" + ColorUtils.ANSI_GREEN + "Assistant" + "\n"
                + "\t" + ColorUtils.ANSI_RED + "name = " + ColorUtils.ANSI_WHITE + "" + name + "\n"
                + "\t" + ColorUtils.ANSI_RED + "level = " + ColorUtils.ANSI_WHITE + "" + level + "\n"
                + "\t" + ColorUtils.ANSI_RED + "types = " + ColorUtils.ANSI_WHITE + "" + types + "\n"
                + "\t" + ColorUtils.ANSI_RED + "guests = " + ColorUtils.ANSI_WHITE + "" + guests + "\n";
    }
}
