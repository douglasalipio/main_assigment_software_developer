package main;

import setup.Fabric;
import setup.PokeException;
import entity.Pokemon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hal-9000
 */
public class HotelPokemonMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            System.out.println(new Fabric().buildAssistants().toString());

        } catch (Exception ex) {
            Logger.getLogger(HotelPokemonMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
