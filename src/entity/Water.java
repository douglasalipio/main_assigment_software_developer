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
public class Water {

    private Category category;

    public Water(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category {

        WATER,
        ICE,
        DARK
    }
}
