package views.strategies;

import logic.Pizza;
import logic.PizzaHandler;
import views.PizzaEventListener;
import views.PizzaHandlingStrategy;

/**
 * @author G
 */
public class UpdatePizzaStrategy implements PizzaHandlingStrategy {

    @Override
    public void save(Pizza p) {
        PizzaHandler.updatePizza(p);
    }

    @Override
    public void notify(Pizza p, PizzaEventListener l) {
        l.pizzaUpdated();
    }

}
