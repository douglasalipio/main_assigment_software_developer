/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import java.util.ArrayList;
import java.util.stream.Collectors;
import setup.Fabric;
import setup.PokeException;

/**
 * Class responsible to the business logic.
 *
 * @author hal-9000
 */
public class HotelPokemonPresenter implements HotelPokemonContract.BasePresenter {

    private HotelPokemonContract.BaseView view;

    @Override
    public void attach(HotelPokemonUI view) {
        this.view = view;
    }

    /**
     * Finding all Pokemons.
     */
    @Override
    public void findSeekingRooms() {
        try {
            view.showAllPokemons(Fabric.instance().getPokemons());
        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }

    /**
     * How many empty rooms.
     */
    @Override
    public void getEmptyRooms() {
        try {
            var fabric = Fabric.instance();
            var emptyRooms = fabric.getRooms()
                    .stream()
                    .filter(romm -> romm.getGuest() == null)
                    .collect(Collectors.toList());
            view.showTotalEmptyRooms(emptyRooms.size());
        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }

    }

    /**
     * Unassigned assistants.
     */
    @Override
    public void unssignedAssistants() {
        try {
            var fabric = Fabric.instance();
            var assistants = fabric.getAssistants()
                    .stream()
                    .filter(assistant -> assistant.getGuests() == null)
                    .collect(Collectors.toList());
            view.showTotalUnssignedAssistant(assistants.size());
        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }

    }

    /**
     * Searching assistant by ID.
     *
     * @param id
     */
    @Override
    public void submitSearchAssistant(long id) {
        var rooms = new ArrayList();

        try {
            var fabric = Fabric.instance();
            var assistant = fabric.getAssistants()
                    .stream()
                    .filter(it -> it.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (assistant != null) {
                assistant.getGuests().forEach((guest) -> {
                    if (guest != null) {
                        var room = fabric.getRooms()
                                .stream()
                                .filter(it -> it.getGuest() != null)
                                .filter(it -> it.getGuest().getId() == guest.getId())
                                .findAny()
                                .orElse(null);
                        if (room != null) {
                            rooms.add(room);

                        }
                    }

                });
            }
            view.showPersonalAssistant(rooms, assistant);
        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }

    /**
     * All Pokemons who is in a room.
     *
     */
    @Override
    public void allPokemonsAccommodated() {
        try {
            var busyRoom = Fabric.instance().getRooms()
                    .stream()
                    .filter(room -> room.getAssistantId() > 0)
                    .filter(room -> room.getGuest() != null)
                    .collect(Collectors.toList());
            if (busyRoom != null) {
                view.showTotalHotelAccommodate(busyRoom);
            }

        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }

    /**
     * Finding pokemons who does not have a room.
     *
     */
    @Override
    public void findPokemonsWaitingList() {
        try {
            var fabric = Fabric.instance();
            var waitingList = fabric.getPokemons();
            fabric.getAssistants().forEach((assistant) -> {
                waitingList.removeAll(assistant.getGuests());
            });
            view.showWaitingList(waitingList);
        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }

    /**
     * Searching room by ID.
     *
     * @param id
     */
    @Override
    public void submitSearchRoom(long id) {
        try {
            var room = Fabric.instance().getRooms()
                    .stream()
                    .filter(it -> it.getId() == id)
                    .findAny()
                    .orElse(null);
            view.showRoomById(room);

        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }

    /**
     * Searching category by name.
     *
     * @param category
     */
    @Override
    public void submitSearchCategory(String category) {
        try {
            var pokemons = Fabric.instance().getPokemons()
                    .stream()
                    .filter(it -> it.getCategory().getName()
                    .equalsIgnoreCase(category.trim()))
                    .collect(Collectors.toList());

            view.showGeneticStamp(pokemons);

        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }
}
