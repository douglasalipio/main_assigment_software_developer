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
 * Class who represent a Land
 *
 * @author hal-9000
 */
public class Land extends Category {

    @SerializedName("types")
    @Expose
    private List<String> types = null;

    /**
     * Getting types of the land.
     *
     * @return
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * Set types of the land.
     *
     * @param types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * Printing land.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Land{" + "types=" + types + '}';
    }

}
