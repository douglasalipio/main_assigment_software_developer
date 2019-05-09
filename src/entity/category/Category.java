/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.category;

/**
 *
 * @author hal-9000
 */
public class Category<T> {

    private T t;
    private String type;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
