/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * Class who represent an Air category
 *
 * @author hal-9000
 */
public class Air extends Category {

    @SerializedName("types")
    @Expose
    private List<String> types = null;

    /**
     * Getting the types of the Air.
     *
     * @return
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * Set the type of Air category.
     *
     * @param types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * Printing air class.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Air{" + "types=" + types + '}';
    }

}
