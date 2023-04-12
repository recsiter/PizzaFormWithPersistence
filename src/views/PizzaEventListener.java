package views;

import logic.Pizza;

/**
 *
 * @author --G--
 */
public interface PizzaEventListener {

    void pizzaCreated(Pizza newPizza);

    void pizzaUpdated();
}
