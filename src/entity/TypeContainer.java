/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class who the category of the Pokemons. Eg: Land, Water or Air.
 *
 * @author hal-9000
 */
public class TypeContainer {

    @SerializedName("air")
    @Expose
    private Air air;
    @SerializedName("land")
    @Expose
    private Land land;
    @SerializedName("water")
    @Expose
    private Water water;

    /**
     * Creating an air object.
     *
     * @return
     */
    public Air getAir() {
        return air;
    }

    /**
     * Set air.
     *
     * @param air
     */
    public void setAir(Air air) {
        this.air = air;
    }

    /**
     * Getting land.
     *
     * @return
     */
    public Land getLand() {
        return land;
    }

    /**
     * Set land.
     *
     * @param land
     */
    public void setLand(Land land) {
        this.land = land;
    }

    /**
     * Getting water
     *
     * @return
     */
    public Water getWater() {
        return water;
    }

    /**
     * Set water
     *
     * @param water
     */
    public void setWater(Water water) {
        this.water = water;
    }
}
