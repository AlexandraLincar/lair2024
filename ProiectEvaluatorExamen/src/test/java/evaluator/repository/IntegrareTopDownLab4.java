package evaluator.repository;

import evaluator.controller.AppController;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegrareTopDownLab4 {
    /**
     * Testare unitara (A)
     */
    @Test
    public void testAddNewIntrebare() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("40","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu"));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    /**
     * Test create new test (A & B)
     * P -> A -> B
     */
    @Test
    public void testCreateNewTestPAB() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("41","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu1"));
            ctrl.addNewIntrebare(new Intrebare("42","Intrebare2?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("43","Intrebare3?", "1)a", "2)b", "3)c", "1", "Domeniu3"));
            ctrl.addNewIntrebare(new Intrebare("44","Intrebare4?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
            ctrl.addNewIntrebare(new Intrebare("45","Intrebare5?", "1)a", "2)b", "3)c", "1", "Domeniu5"));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

        try {
            ctrl.createNewTest();
            assertTrue(true);
        } catch (NotAbleToCreateTestException e) {
            assertTrue(false);
        }
    }

    /**
     * Test get statistica (A & B & C)
     * P -> A -> B -> C
     */
    @Test
    public void testGetStatisticaPABC() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("46","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu1"));
            ctrl.addNewIntrebare(new Intrebare("47","Intrebare2?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("48","Intrebare3?", "1)a", "2)b", "3)c", "1", "Domeniu3"));
            ctrl.addNewIntrebare(new Intrebare("49","Intrebare4?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
            ctrl.addNewIntrebare(new Intrebare("50","Intrebare5?", "1)a", "2)b", "3)c", "1", "Domeniu5"));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

        try {
            ctrl.createNewTest();
            assertTrue(true);
        } catch (NotAbleToCreateTestException e) {
            assertTrue(false);
        }

        try {
            Statistica stats = ctrl.getStatistica();
            assertTrue(true);

            Map<String, Integer> map = stats.getIntrebariDomenii();

            assertEquals(1, (int) map.get("Domeniu1"));
            assertEquals(1, (int) map.get("Domeniu2"));
            assertEquals(1, (int) map.get("Domeniu3"));
            assertEquals(1, (int) map.get("Domeniu4"));
            assertEquals(1, (int) map.get("Domeniu5"));
        } catch (NotAbleToCreateStatisticsException e) {
            assertTrue(false);
        }
    }
}
