/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import entity.Assistant;
import entity.Pokemon;
import entity.Room;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
        System.out.println("(1) All pokemons");
        System.out.println("(2) Pokemon group can accomodate on the hotel");
        System.out.println("(3) The Pokemon group cannot accommodate on the hotel");
        System.out.println("(4) Un-ocuppied rooms");
        System.out.println("(5) Un-assigned personal assistants");
        System.out.println("(6) Searching personal assistant");

        int option = reader.nextInt();
        switch (option) {
            case 1:
                presenter.findSeekingRooms();
                break;
            case 2:
                presenter.allPokemonsAccommodated();
                break;
            case 3:
                presenter.findPokemonsWaitingList();
                break;
            case 4:
                presenter.getEmptyRooms();
                break;
            case 5:
                presenter.unssignedAssistants();
                break;
            case 6:
                showSearchAssistant();
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
        presenter.submitSearchAssistant(reader.nextLong());
    }

    @Override
    public void showAllPokemons(LinkedList<Pokemon> pokemons) {
        Collections.shuffle(pokemons);
        pokemons.forEach((pokemon) -> {
            System.out.println(pokemon.toString());
        });
        backMenu();
    }

    @Override
    public void showTotalHotelAccomodate(List<Room> rooms) {
        rooms.forEach((pokemon) -> {
            System.out.print(pokemon.toString() + " | ");
        });
        System.out.println("Total hotel can accommodate: " + rooms.size());
        backMenu();
    }

    @Override
    public void showWaitingList(LinkedList<Pokemon> waitingList) {
        waitingList.forEach((pokemon) -> {
            System.out.println(pokemon.toString());
        });
        System.out.println("Total of pokemons cannot be accommodate is " + waitingList.size());
        backMenu();
    }

    @Override
    public void showPersonalAssistant(ArrayList rooms, Assistant assistant) {
        rooms.forEach((room) -> {
            System.out.println(room.toString());
        });
        System.out.println(assistant.toString());
    }
}
