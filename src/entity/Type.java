/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class Type {

    private final String name;
    public static int LIMIT = 2;

    public Type(String name, String type) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Type{" + "name=" + name + '}';
    }

}
