package evaluator.repository;

import evaluator.controller.AppController;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCerintaIII {
    /**
     * Test case if no questions exist
     */
    @Test
    public void testStatisticaNonValid() {
        AppController ctrl = new AppController();

        try {
            ctrl.getStatistica();
            assertTrue(false);
        } catch (NotAbleToCreateStatisticsException e) {
            assertTrue(true);
        }
    }

    /**
     * Test case if questions exist
     */
    @Test
    public void testStatisticaValid() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("10","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu1"));
            ctrl.addNewIntrebare(new Intrebare("11","Intrebare2?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("12","Intrebare3?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("13","Intrebare4?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
            ctrl.addNewIntrebare(new Intrebare("14","Intrebare5?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
        } catch (InputValidationFailedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test
        try {
            Statistica stats = ctrl.getStatistica();
            assertTrue(true);

            Map<String, Integer> map = stats.getIntrebariDomenii();
            // map.get("Domeniu1") => nr de intrebari dint-un domeniu
            assertEquals(1, (int) map.get("Domeniu1"));
            assertEquals(2, (int) map.get("Domeniu2"));
            assertEquals(2, (int) map.get("Domeniu4"));
        } catch (NotAbleToCreateStatisticsException e) {
            assertTrue(false);
        }
    }

}
