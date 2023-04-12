package views;

import logic.Pizza;

/**
 *
 * @author --G--
 */
public interface PizzaHandlingStrategy {

    void save(Pizza p);

    void notify(Pizza p, PizzaEventListener l);
}
