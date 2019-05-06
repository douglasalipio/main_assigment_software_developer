/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author hal-9000
 */
public class Air {

    private final Category category;

    public Air(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category {

        FIRE,
        ELETRIC,
        FLY,
        PSYCHIC,
        BUG,
        DRAGON,
        FAIRY,
        GHOST
    }

}
