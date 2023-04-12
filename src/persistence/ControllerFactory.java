package persistence;

import utils.FoodType;

/**
 * @author G
 */
public class ControllerFactory {

    public static Controller createController(FoodType type) {
        switch (type) {
            case DESSERT:
                return new DessertController();
            default:
                return new PizzaController();

        }
    }
}
