/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.PokemonException;
import data.PokemonReader;
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

            for (String pokemonName : PokemonReader
                    .getInstance(PokemonReader.Type.POKEMON_NAME).getPokemonNames()) {
                System.out.println(pokemonName);
            }

        } catch (PokemonException ex) {
            Logger.getLogger(HotelPokemonMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
