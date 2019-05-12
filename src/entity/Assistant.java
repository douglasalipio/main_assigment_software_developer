package entity;

import setup.PokeException;
import java.util.ArrayList;
import java.util.List;
import utils.ColorUtils;

/**
 *
 * @author hal-9000
 */
public class Assistant {

    private final String name;
    private final int level;
    private final List<String> types = new ArrayList();
    private final List<Pokemon> guests = new ArrayList();
    private static final int LIMIT_GUEST = 5;
    private static final int LIMIT_TYPES = 2;

    public Assistant(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<Pokemon> getGuests() {
        return guests;
    }

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

    @Override
    public String toString() {
        return "" + ColorUtils.ANSI_GREEN + "Assistant" + "\n"
                + "\t" + ColorUtils.ANSI_RED + "name = " + ColorUtils.ANSI_WHITE + "" + name + "\n"
                + "\t" + ColorUtils.ANSI_RED + "level = " + ColorUtils.ANSI_WHITE + "" + level + "\n"
                + "\t" + ColorUtils.ANSI_RED + "types = " + ColorUtils.ANSI_WHITE + "" + types + "\n"
                + "\t" + ColorUtils.ANSI_RED + "guests = " + ColorUtils.ANSI_WHITE + "" + guests + "\n";
    }
}
