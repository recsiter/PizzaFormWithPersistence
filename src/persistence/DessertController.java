package persistence;

import java.util.ArrayList;
import java.util.List;
import logic.Dessert;
import logic.Food;
import logic.Pizza;

/**
 * @author G
 */
class DessertController implements Controller {

    private static final String FILE_NAME = "desserts.txt";

    @Override
    public void insert(Food f) {
        List<List<String>> data = FileHandler.readIn(FILE_NAME);
        List<String> dessertRow = createListFromDessert((Dessert) f);
        data.add(dessertRow);
        FileHandler.writeOut(data, FILE_NAME);
    }

    @Override
    public void update(Food f) {
        List<Dessert> desserts = parseFoodListToDessertList();
        int index = desserts.indexOf((Dessert) f);
        if (index > -1) {
            desserts.set(index, (Dessert) f);
            List<List<String>> writable = stringListFromDessertList(desserts);
            FileHandler.writeOut(writable, FILE_NAME);
        }
    }

    @Override
    public void delete(Food f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<String> createListFromDessert(Dessert dessert) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(dessert.getId()));
        result.add(dessert.getName());
        result.add(String.valueOf(dessert.getPrice()));
        result.add(String.valueOf(dessert.isBig()));
        return result;
    }

    private List<List<String>> stringListFromDessertList(List<Dessert> desserts) {
        List<List<String>> result = new ArrayList<>();
        for (Dessert dessert : desserts) {
            result.add(createListFromDessert(dessert));
        }
        return result;
    }

    @Override
    public List<Food> getAllFood() {
        List<List<String>> rows = FileHandler.readIn(FILE_NAME);
        List<Food> result = new ArrayList<>();
        for (List<String> row : rows) {
            Dessert temp = createDessertFromStringList(row);
            result.add(temp);
        }
        return result;
    }

    private Dessert createDessertFromStringList(List<String> row) {
        Dessert dessert = new Dessert();
        dessert.setId(Long.parseLong(row.get(0)));
        dessert.setName(row.get(1));
        dessert.setPrice(Integer.parseInt(row.get(2)));
        dessert.setBig(Boolean.parseBoolean(row.get(3)));
        return dessert;
    }

    private List<Dessert> parseFoodListToDessertList() {
        List<Food> foods = getAllFood();
        List<Dessert> desserts = new ArrayList<>();
        for (Food food : foods) {
            desserts.add((Dessert) food);
        }
        return desserts;
    }

}
