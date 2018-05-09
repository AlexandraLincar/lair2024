package evaluator.repository;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class IntrebariRepositoryTest {

    @org.junit.jupiter.api.Test
    void testAddIntrebare() {
        AppController ctrl = new AppController();

        try {
            ctrl.addNewIntrebare(new Intrebare("20","Intrebare1?", "1)a", "2)b", "3)c", "1", "Domeniu"));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareEnunt() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertEquals(new Intrebare("20", "Care este intrebarea?", "1) Asta", "2) Cealalta", "3) Niciuna", "3", "Random"), newIntrebare);
            Assert.assertNotEquals("Care este intrebarea", newIntrebare.getEnunt());
            Assert.assertEquals("Care este intrebarea?", newIntrebare.getEnunt());
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareDomeniu() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertEquals(new Intrebare("20", "Care este intrebarea?", "1) Asta", "2) Cealalta", "3) Niciuna", "3", "Random"), newIntrebare);
            Assert.assertNotEquals("random", newIntrebare.getDomeniu());
            Assert.assertEquals("Random", newIntrebare.getDomeniu());
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareEmpty() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertFalse(newIntrebare.getEnunt().isEmpty());
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareSpaces() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertFalse(newIntrebare.getEnunt().trim().isEmpty());
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareStrings() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertTrue(newIntrebare.getEnunt() instanceof String);
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareLength() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertFalse(newIntrebare.getEnunt().length() > 100);
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

//    @org.junit.jupiter.api.Test
//    void testAddIntrebare() {
//        IntrebariRepository intrebariRepository = new IntrebariRepository();
//        String id = "20";
//        String enunt = "Care este intrebarea?";
//        String varianta1 = "1) Asta";
//        String varianta2 = "2) Cealalta";
//        String varianta3 = "3) Niciuna";
//        String variantaCorecta = "3";
//        String domeniu = "Random";
//        try {
//            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
//            intrebariRepository.addIntrebare(newIntrebare);
//            Assert.assertFalse(intrebariRepository.getIntrebari().isEmpty());
//        } catch (InputValidationFailedException e) {
//            System.out.println(e.toString());
//        } catch (DuplicateIntrebareException e) {
//            e.printStackTrace();
//        }
//    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareVariante() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertTrue(String.valueOf(newIntrebare.getVarianta1().charAt(0)).equals("1"));
            Assert.assertTrue(String.valueOf(newIntrebare.getVarianta1().charAt(1)).equals(")"));
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareVariantaCorecta() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertTrue(newIntrebare.getVariantaCorecta().equals("1") || newIntrebare.getVariantaCorecta().equals("2") || newIntrebare.getVariantaCorecta().equals("3"));
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testAddIntrebareIsUpperCase() {
        String id = "20";
        String enunt = "Care este intrebarea?";
        String varianta1 = "1) Asta";
        String varianta2 = "2) Cealalta";
        String varianta3 = "3) Niciuna";
        String variantaCorecta = "3";
        String domeniu = "Random";
        try {
            Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
            Assert.assertTrue(Character.isUpperCase(newIntrebare.getDomeniu().charAt(0)));
        } catch (InputValidationFailedException e) {
            System.out.println(e.toString());
        }
    }
}