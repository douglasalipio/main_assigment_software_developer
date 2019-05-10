package entity;

import utils.ColorUtils;

/**
 *
 * @author hal-9000
 */
public class Room {

    private final long id;
    private int resistence;
    private Pokemon guest = null;

    public Room(int resistence) {
        this.id = System.nanoTime();
        this.resistence = resistence;
    }

    public long getId() {
        return id;
    }

    public int getResistence() {
        return resistence;
    }

    public Pokemon getGuest() {
        return guest;
    }

    public boolean accept(Pokemon pokemon) {
        var pokemonAttack = pokemon.getSpecialAttack() + pokemon.getSpeedRate() / 3;
        if (pokemonAttack > resistence) {
            guest = pokemon;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + ColorUtils.ANSI_GREEN + "Room:" + "\n"
                + "\t" + ColorUtils.ANSI_RED + "id = " + ColorUtils.ANSI_WHITE + "" + id + "\n"
                + "\t" + ColorUtils.ANSI_RED + "resistence = " + ColorUtils.ANSI_WHITE + "" + resistence + "\n"
                + "\t" + ColorUtils.ANSI_RED + "guest = " + ColorUtils.ANSI_WHITE + "" + guest + "\n";
    }

}
