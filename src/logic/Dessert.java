package logic;

/**
 * @author G
 */
public class Dessert implements Food {

    private long id;
    private String name;
    private int price;
    private boolean big;

    public Dessert() {
    }

    public Dessert(long id, String name, int price, boolean big) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.big = big;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBig() {
        return big;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

}
