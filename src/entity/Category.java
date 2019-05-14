package entity;

/**
 *
 * Class who represent a Category
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
    
    /**
     * Getting category.
     * 
     * @return 
     */
    public T get() {
        return this.t;
    }
    
    /**
     * Set category.
     * 
     * @param t1 
     */
    public void set(T t1) {
        this.t = t1;
    }
    
    /**
     * Getting type
     * 
     * @return 
     */
    public String getType() {
        return type;
    }

    /**
     * Getting name
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set type of the category.
     * 
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
}
