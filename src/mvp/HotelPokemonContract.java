/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

/**
 *
 * @author hal-9000
 */
public class HotelPokemonContract {

    public interface BaseView {
        
        public void showGenericError(String message);

        public void showTotalEmptyRooms(int size);

        public void showTotalUnssignedAssistant(int size);
    }

    public interface BasePresenter {

        public void attach(HotelPokemonUI view);

        public void findSeekingRooms();

        public void getEmptyRooms();

        public void unssignedAssistants();

    }

}
