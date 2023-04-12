package logic;

import java.util.ArrayList;
import java.util.List;
import persistence.Controller;
import persistence.ControllerFactory;
import utils.FoodType;

/**
 *
 * @author G
 */
public class PizzaHandler {

    private static final Controller CONTROLLER;

    static {
        CONTROLLER = ControllerFactory.createController(FoodType.PIZZA);
    }

    private PizzaHandler() {
    }

    public static List<Pizza> getPizzaList() {

        List<Food> foods = CONTROLLER.getAllFood();
        List<Pizza> pizzas = new ArrayList<>();
        for (Food food : foods) {
            pizzas.add((Pizza) food);
        }
        return pizzas;
    }

    public static void savePizza(Pizza p) {
        CONTROLLER.insert(p);
    }

    public static void updatePizza(Pizza p) {
        CONTROLLER.update(p);
    }

}
