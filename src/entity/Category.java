package entity;

/**
 *
 * @author hal-9000
 */
public class Category<T> {

    private T t;
    private String type;
    private final String name;

    public Category() {
        name = getClass().getName().replace("entity.", "");
    }

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
