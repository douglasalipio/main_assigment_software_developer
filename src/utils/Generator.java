/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *Just building unique ID.
 * 
 * @author hal-9000
 */
public class Generator {

    private static long idCounter = 0;
    private static Generator instance;

    /**
     * Private instance.
     */
    private Generator() {

    }

    /**
     * Creating instance.
     *
     * @return
     */
    public static Generator instance() {
        if (instance == null) {
            return new Generator();
        }
        return instance;
    }

    /**
     * Generating a unique ID.
     *
     * @return
     */
    public synchronized long createID() {
        return (idCounter++);
    }
}
