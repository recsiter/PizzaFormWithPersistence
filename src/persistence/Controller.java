package persistence;

import java.util.List;
import logic.Food;
import logic.Pizza;

/**
 *
 * @author --G--
 */
public interface Controller {

    void insert(Food f);

    void update(Food f);

    void delete(Food f);

    List<Food> getAllFood();
}
