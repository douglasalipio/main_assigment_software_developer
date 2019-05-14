package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Class who represent a Water category.
 *
 * @author hal-9000
 */
public class Water extends Category {

    @SerializedName("types")
    @Expose
    private List<String> types = null;

    /**
     * Getting types.
     *
     * @return
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * Set types.
     *
     * @param types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * Printing water object.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Water{" + "types=" + types + '}';
    }
}
