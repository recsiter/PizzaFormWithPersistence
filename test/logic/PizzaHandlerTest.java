package logic;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author --G--
 */
public class PizzaHandlerTest {

    public PizzaHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPizzaList method, of class PizzaHandler.
     */
    @Test
    public void testGetPizzaList() {
        System.out.println("getPizzaList");
        List<Pizza> expResult = null;
        List<Pizza> result = PizzaHandler.getPizzaList();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of savePizza method, of class PizzaHandler.
     */
    @Test
    @Ignore
    public void testSavePizza() {
        System.out.println("savePizza");
        Pizza p = new Pizza(111, "name", 40, 3200, true);
        PizzaHandler.savePizza(p);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePizza method, of class PizzaHandler.
     */
    @Test
    public void testUpdatePizza() {
        System.out.println("updatePizza");
        Pizza p = new Pizza(111, "Lószar", 40, 3200, true);
        PizzaHandler.updatePizza(p);
        assertEquals(PizzaHandler.getPizzaList().
                get(3), p);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
