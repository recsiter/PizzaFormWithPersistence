package persistence;

import java.util.ArrayList;
import java.util.List;
import logic.Food;
import logic.Pizza;

/**
 * @author G
 */
class PizzaController implements Controller {

    public static final String FILE_NAME = "pizza.txt";

    @Override
    public void insert(Food pizza) {
        List<List<String>> data = FileHandler.readIn(FILE_NAME);
        List<String> pizzaRow = createListFromPizza((Pizza) pizza);
        data.add(pizzaRow);
        FileHandler.writeOut(data, FILE_NAME);
    }

    @Override
    public void update(Food pizza) {
        List<Pizza> pizzas = changeFoodListToPizzaList();
        int index = pizzas.indexOf(pizza);
        if (index > -1) {
            pizzas.set(index, (Pizza) pizza);
            List<List<String>> writable = stringListFromPizzaList(pizzas);
            FileHandler.writeOut(writable, FILE_NAME);
        }
    }

    private List<Pizza> changeFoodListToPizzaList() {
        List<Food> foods = getAllFood();
        List<Pizza> pizzas = new ArrayList<>();
        for (Food food : foods) {
            pizzas.add((Pizza) food);
        }
        return pizzas;
    }

    @Override
    public void delete(Food pizza) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<List<String>> stringListFromPizzaList(List<Pizza> pizzas) {
        List<List<String>> result = new ArrayList<>();
        for (Pizza pizza : pizzas) {
            result.add(createListFromPizza(pizza));
        }
        return result;
    }

    @Override
    public List<Food> getAllFood() {
        List<List<String>> rows = FileHandler.readIn(FILE_NAME);
        List<Food> result = new ArrayList<>();
        for (List<String> row : rows) {
            Pizza temp = createPizzaFromStringList(row);
            result.add(temp);
        }
        return result;
    }

    private List<String> createListFromPizza(Pizza pizza) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(pizza.getId()));
        result.add(pizza.getName());
        result.add(String.valueOf(pizza.getDiameter()));
        result.add(String.valueOf(pizza.getPrice()));
        result.add(String.valueOf(pizza.isSpicy()));
        return result;
    }

    private Pizza createPizzaFromStringList(List<String> row) {
        long id = Long.parseLong(row.get(0));
        String name = row.get(1);
        int diameter = Integer.parseInt(row.get(2));
        int price = Integer.parseInt(row.get(3));
        boolean spicy = Boolean.parseBoolean(row.get(4));
        return new Pizza(id, name, diameter, price, spicy);
    }

}
