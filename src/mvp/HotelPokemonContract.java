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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class HotelPokemonContract {

    public interface BaseView {
        
        public void showGenericError(String message);

        public void showTotalEmptyRooms(int size);

        public void showTotalUnssignedAssistant(int size);

        public void showAllPokemons(LinkedList<Pokemon> pokemons);

        public void showTotalHotelAccomodate(List<Room> rooms);

        public void showWaitingList(LinkedList<Pokemon> waitingList);

        public void showPersonalAssistant(ArrayList rooms, Assistant assistant);
    }

    public interface BasePresenter {

        public void attach(HotelPokemonUI view);

        public void findSeekingRooms();

        public void getEmptyRooms();

        public void unssignedAssistants();

        public void submitSearchAssistant(long id);

        public void allPokemonsAccommodated();

        public void findPokemonsWaitingList();

    }

}
