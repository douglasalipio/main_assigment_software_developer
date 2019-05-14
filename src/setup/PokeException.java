package setup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * Generic exception for the project.
 *
 * @author hal-9000
 */
public class PokeException extends Exception {

    /**
     * Creating a Pokemon exception with a message.
     *
     * @param message
     */
    public PokeException(String message) {
        super(message);
    }
}
