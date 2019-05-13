/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import entity.Pokemon;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author hal-9000
 */
public class HotelPokemonUI implements HotelPokemonContract.BaseView {

    private final HotelPokemonContract.BasePresenter presenter = new HotelPokemonPresenter();

    public HotelPokemonUI() {
        presenter.attach(this);
    }

    public void showMainMenu() {

        Scanner reader = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("-----Welcome to Pokemon Hotel-----");
        System.out.println("----------------------------------");
        System.out.println("Alex                    No 2018274");
        System.out.println("Catia                   No 2018274");
        System.out.println("Douglas                 No 2018274");
        System.out.println("----------------------------------");
        System.out.println("---------------MENU---------------");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("(1) The Pokemon group seeking room");
        System.out.println("(2) The Total of the Pokemon group can accommodate on hotel");
        System.out.println("(3) The Pokemon group can accommodate on hotel");
        System.out.println("(4) The Pokemon group cannot accommodate on hotel");
        System.out.println("(5) Un-ocuppied rooms");
        System.out.println("(6) Un-assigned personal assistants");
        System.out.println("(7) Searching personal assistant");

        int option = reader.nextInt();
        switch (option) {
            case 1:
                presenter.findSeekingRooms();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                presenter.getEmptyRooms();
                break;
            case 6:
                presenter.unssignedAssistants();
                break;
            case 7:

                break;
        }
    }

    @Override
    public void showGenericError(String message) {
        System.err.print("Something wrong. Try again!");
    }

    @Override
    public void showTotalEmptyRooms(int size) {
        System.out.println("Empty rooms: " + size);
        backMenu();
    }

    @Override
    public void showTotalUnssignedAssistant(int size) {
        System.out.println("Unassigned assistants: " + size);
        backMenu();
    }

    private void backMenu() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\n1 - Main menu");
        System.out.println("0 - Close");
        int option = reader.nextInt();
        switch (option) {
            case 1:
                showMainMenu();
                break;
            default:
                break;
        }

    }

    private void showSearchAssistant() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nEnter assistant ID:");
        int option = reader.nextInt();
        switch (option) {
            case 1:
                presenter.submitSearchAssistant(option);
                break;
            default:
                break;
        }
    }

    @Override
    public void showAllPokemons(LinkedList<Pokemon> pokemons) {
        Collections.shuffle(pokemons);
        pokemons.forEach((pokemon) -> {
            System.out.println(pokemon.toString());
        });
        backMenu();
    }
}
