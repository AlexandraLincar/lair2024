package evaluator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;

import evaluator.controller.AppController;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.model.Test;
import evaluator.util.InputValidation;

//functionalitati
//i.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//ii.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//iii.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

	private static final String file = "intrebari.txt";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		AppController appController = new AppController();
		
		boolean activ = true;
		String optiune = null;
		
		while(activ){
			
			System.out.println("");
			System.out.println("1.Adauga intrebare");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Exit");
			System.out.println("");
			
			optiune = console.readLine();
			
			switch(optiune){
			case "1" :
				addIntrebare();
				break;
			case "2" :
				createNewTest();
				break;
			case "3" :
				generateStatistica();
				break;
			case "4" :
				activ = false;
				break;
			default:
				break;
			}
		}
	}

	private static void createNewTest() {
		AppController appController = new AppController();
		appController.loadIntrebariFromFile(file);
		Test test;
		try {
			test = appController.createNewTest();
			System.out.println(test.getIntrebari());
		} catch (NotAbleToCreateTestException e) {
			System.out.println(e.toString());
		}
	}

	private static void generateStatistica() {
		AppController appController = new AppController();
		appController.loadIntrebariFromFile(file);
		Statistica statistica;
		try {
			statistica = appController.getStatistica();
			System.out.println(statistica);
		} catch (NotAbleToCreateStatisticsException e) {
			System.out.println("Not Able To Create Statistics");
		}
	}

	private static void addIntrebare() throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		AppController appController = new AppController();
		String id;
		String enunt;
		String varianta1;
		String varianta2;
		String varianta3;
		String variantaCorecta;
		String domeniu;

		System.out.println("Introduceti id-ul: ");
		id = console.readLine();

		System.out.println("Introduceti enuntul: ");
		enunt = console.readLine();

		System.out.println("Introduceti varianta 1: ");
		varianta1 = console.readLine();

		System.out.println("Introduceti varianta 2: ");
		varianta2 = console.readLine();

		System.out.println("Introduceti varianta 3: ");
		varianta3 = console.readLine();

		System.out.println("Introduceti varianta corecta: ");
		variantaCorecta = console.readLine();

		System.out.println("Introduceti domeniul: ");
		domeniu = console.readLine();

		try {
			Intrebare newIntrebare = new Intrebare(id, enunt, varianta1, varianta2, varianta3, variantaCorecta, domeniu);
			appController.addNewIntrebare(newIntrebare);
			appController.saveIntrebareIntoFile(file, newIntrebare);

			System.out.println("Intrebarea este: " + newIntrebare.toString());
		} catch (InputValidationFailedException er) {
			System.out.println(er.toString());
		} catch (DuplicateIntrebareException e) {
			e.printStackTrace();
		}


	}

}
