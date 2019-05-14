package entity;

import utils.ColorUtils;
import utils.Generator;

/**
 *
 * @author hal-9000
 */
public class Room {

    private final long id;
    private final int resistence;
    private Pokemon guest = null;
    private long assistantId;

    public Room(int resistence) {
        this.id = Generator.instance().createID();
        this.resistence = resistence;
    }

    public long getId() {
        return id;
    }

    public void setAssistantId(long assistantId) {
        this.assistantId = assistantId;
    }

    public int getResistence() {
        return resistence;
    }

    public Pokemon getGuest() {
        return guest;
    }

    public long getAssistantId() {
        return assistantId;
    }

    public boolean accept(Pokemon pokemon) {
        if (pokemon != null) {
            var pokemonAttack = pokemon.getSpecialAttack() + pokemon.getSpeedRate() / 3;
            if (pokemonAttack > resistence) {
                guest = pokemon;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {

        if (guest == null) {
            return "" + ColorUtils.ANSI_GREEN + "Room:" + "\n"
                    + "\t" + ColorUtils.ANSI_RED + "id = " + ColorUtils.ANSI_WHITE + "" + id + "\n"
                    + "\t" + ColorUtils.ANSI_RED + "resistence = " + ColorUtils.ANSI_WHITE + "" + resistence + "\n"
                    + "\t" + ColorUtils.ANSI_RED + "Assistant ID = " + ColorUtils.ANSI_WHITE + "" + assistantId + "\n";
        }

        return "" + ColorUtils.ANSI_GREEN + "Room:" + "\n"
                + "\t" + ColorUtils.ANSI_RED + "id = " + ColorUtils.ANSI_WHITE + "" + id + "\n"
                + "\t" + ColorUtils.ANSI_RED + "resistence = " + ColorUtils.ANSI_WHITE + "" + resistence + "\n"
                + "\t" + ColorUtils.ANSI_RED + "Assistant ID = " + ColorUtils.ANSI_WHITE + "" + assistantId + "\n"
                + "\t" + ColorUtils.ANSI_GREEN + "Guest" + ColorUtils.ANSI_WHITE + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\tid = " + ColorUtils.ANSI_WHITE + "" + guest.getId() + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\tname= " + ColorUtils.ANSI_WHITE + "" + guest.getName() + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\tspeedAttack = " + ColorUtils.ANSI_WHITE + "" + guest.getSpecialAttack() + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\tspeedRate = " + ColorUtils.ANSI_WHITE + "" + guest.getSpeedRate() + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\tlevel = " + ColorUtils.ANSI_WHITE + "" + guest.getLevel() + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\tcategory = " + ColorUtils.ANSI_WHITE + "" + guest.getClass().getName().replace("entity.", "") + "\n"
                + "\t" + ColorUtils.ANSI_RED + "\ttype = " + ColorUtils.ANSI_WHITE + "" + guest.getType() + "\n";
    }

}
