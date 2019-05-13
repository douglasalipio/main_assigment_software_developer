/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import java.util.stream.Collectors;
import setup.Fabric;
import setup.PokeException;

/**
 *
 * @author hal-9000
 */
public class HotelPokemonPresenter implements HotelPokemonContract.BasePresenter {

    private HotelPokemonContract.BaseView view;

    public HotelPokemonPresenter() {
    }

    @Override
    public void attach(HotelPokemonUI view) {
        this.view = view;
    }

    @Override
    public void findSeekingRooms() {
        try {
            view.showAllPokemons(Fabric.instance().getPokemons());
        } catch (PokeException ex) {
            view.showGenericError(ex.getMessage());
        }
    }

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

    @Override
    public void submitSearchAssistant(int id) {

    }

}
