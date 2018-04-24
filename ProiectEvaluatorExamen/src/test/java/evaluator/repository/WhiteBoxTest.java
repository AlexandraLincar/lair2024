package evaluator.repository;
import evaluator.controller.AppController;
import org.junit.Test;

public class WhiteBoxTest {
    public static String NU_EXISTA_SUFICIENTE_INTREBARI = "Nu exista suficiente intrebari pentru crearea unui test!(5)";
    public static String NU_EXISTA_SUFICIENTE_DOMENII = "Nu exista suficiente domenii pentru crearea unui test!(5)";

    @Test
    public void test_one() {
        try {
            AppController appController = new AppController();
            appController.loadIntrebariFromFile("NrIntrebariInvalid.txt");
            evaluator.model.Test test = appController.createNewTest();
        } catch (Exception ex) {
            assert (ex.getMessage().equals(NU_EXISTA_SUFICIENTE_INTREBARI));
        }
    }

    @Test
    public void test_two() {
        try {
            AppController appController = new AppController();
            appController.loadIntrebariFromFile("NrDomeniiInvalid.txt");
            evaluator.model.Test test = appController.createNewTest();
        } catch (Exception ex) {
            assert (ex.getMessage().equals(NU_EXISTA_SUFICIENTE_DOMENII));
        }
    }

    @Test
    public void test_three() {
        try {
            AppController appController = new AppController();
            appController.loadIntrebariFromFile("intrebari.txt");
            evaluator.model.Test test = appController.createNewTest();
            assert (test.getIntrebari().size() == 5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
