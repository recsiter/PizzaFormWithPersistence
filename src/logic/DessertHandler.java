package logic;

import java.util.ArrayList;
import java.util.List;
import persistence.Controller;
import persistence.ControllerFactory;
import utils.FoodType;

/**
 * @author G
 */
public class DessertHandler {

    private static final Controller CONTROLLER;

    static {
        CONTROLLER = ControllerFactory.createController(FoodType.DESSERT);
    }

    private DessertHandler() {
    }

//    public static List<Dessert> getDessertList() {
//        return CONTROLLER.getAllDessert();
//    }
    public static void saveDessert(Dessert d) {
        CONTROLLER.insert(d);
    }

    public static void updateDessert(Dessert d) {
        CONTROLLER.update(d);
    }

    public static List<Dessert> getDessertList() {
        List<Food> foods = CONTROLLER.getAllFood();
        List<Dessert> result = new ArrayList<>();
        for (Food food : foods) {
            result.add((Dessert) food);
        }
        return result;
    }
}
