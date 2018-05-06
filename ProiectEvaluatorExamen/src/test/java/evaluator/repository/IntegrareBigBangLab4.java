package evaluator.repository;

import evaluator.controller.AppController;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegrareBigBangLab4 {
    /**
     * Test add new intrebare (A - i)
     */
    @Test
    public void testAddNewIntrebare() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("20","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu"));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    /**
     * Test create new test (B - ii)
     */
    @Test
    public void testCreateNewTest() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("21","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu1"));
            ctrl.addNewIntrebare(new Intrebare("22","Intrebare2?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("23","Intrebare3?", "1)a", "2)b", "3)c", "1", "Domeniu3"));
            ctrl.addNewIntrebare(new Intrebare("24","Intrebare4?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
            ctrl.addNewIntrebare(new Intrebare("25","Intrebare5?", "1)a", "2)b", "3)c", "1", "Domeniu5"));
        } catch (InputValidationFailedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ctrl.createNewTest();
            assertTrue(true);
        } catch (NotAbleToCreateTestException e) {
            assertTrue(false);
        }
    }

    /**
     * Test get statistica (C - iii)
     */
    @Test
    public void testGetStatistica() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("26","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu1"));
            ctrl.addNewIntrebare(new Intrebare("27","Intrebare2?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("28","Intrebare3?", "1)a", "2)b", "3)c", "1", "Domeniu3"));
            ctrl.addNewIntrebare(new Intrebare("29","Intrebare4?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
            ctrl.addNewIntrebare(new Intrebare("30","Intrebare5?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
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

            assertEquals(1, (int) map.get("Domeniu1"));
            assertEquals(1, (int) map.get("Domeniu2"));
            assertEquals(1, (int) map.get("Domeniu3"));
            assertEquals(2, (int) map.get("Domeniu4"));
        } catch (NotAbleToCreateStatisticsException e) {
            assertTrue(false);
        }
    }

    /**
     * Test P -> A -> B -> C
     */

    @Test
    public void testPABC() {
        AppController ctrl = new AppController();

        // Test A
        try {
            ctrl.addNewIntrebare(new Intrebare("31","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu1"));
            ctrl.addNewIntrebare(new Intrebare("32","Intrebare2?", "1)a", "2)b", "3)c", "1", "Domeniu2"));
            ctrl.addNewIntrebare(new Intrebare("33","Intrebare3?", "1)a", "2)b", "3)c", "1", "Domeniu3"));
            ctrl.addNewIntrebare(new Intrebare("34","Intrebare4?", "1)a", "2)b", "3)c", "1", "Domeniu4"));
            ctrl.addNewIntrebare(new Intrebare("35","Intrebare5?", "1)a", "2)b", "3)c", "1", "Domeniu5"));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

        // Test B
        try {
            ctrl.createNewTest();
            assertTrue(true);
        } catch (NotAbleToCreateTestException e) {
            assertTrue(false);
        }

        // Test C
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
