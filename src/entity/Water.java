package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class Water extends Category{

    @SerializedName("types")
    @Expose
    private List<String> types = null;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Water{" + "types=" + types + '}';
    }
}
