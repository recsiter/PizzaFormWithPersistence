package logic;

/**
 * entity class (letezik egy vagy tobb tabla az adatbazisban ezekkel a
 * tulajdonsagokkal)
 *
 * @author G
 */
public class Pizza implements Comparable<Pizza>, Food {

    private long id;
    private String name;
    private int diameter;
    private int price;
    private boolean spicy;

    public Pizza() {
    }

    public Pizza(long id, String name, int diameter, int price, boolean spicy) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.price = price;
        this.spicy = spicy;
    }

    //<editor-fold defaultstate="collapsed" desc="properties">
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

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }
//</editor-fold>

    public int grossPrice(int taxKey) {
        double key = 1 + (taxKey / 100.0);
        return (int) Math.round(price * key);
    }

    @Override
    public int compareTo(Pizza o) {
        return (int) (id - o.id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pizza
                && id == ((Pizza) obj).id;
    }

}
