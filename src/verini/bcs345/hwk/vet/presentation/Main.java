package verini.bcs345.hwk.vet.presentation;

//import java.io.File;

import java.io.*;

//import java.io.FileNotFoundException;

//import java.io.PrintStream;

import java.util.Scanner;

import verini.bcs345.hwk.vet.business.*;

/***
 * This class runs unit tests for the Pet and the Procedure classes
 * 
 * @author mattverini
 * @version 1.0
 * @since 12/13/2018
 */

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Main main = new Main();
		main.chooseUI(args);

		/*
		 * Scanner sPet = new Scanner(new File("Pet.txt")); Scanner sProcedure = new
		 * Scanner(new File("Procedure.txt")); PrintStream psPet = new
		 * PrintStream("Pet.txt"); PrintStream psP = new PrintStream("Procedure.txt");
		 * Main main = new Main();
		 * System.out.println("Unit Testing for Pet and Procedure classes: ");
		 * main.testPet(); main.testProcedure();
		 * 
		 * Pet dog = new Pet("Luigi", "Cockerspaniel", "Male"); Pet dogCopy = new Pet();
		 * Procedure fluShot = new Procedure("Flu Shot", 340.75); Procedure fluShotCopy
		 * = new Procedure(); dog.Write(psPet); fluShot.Write(psP); dogCopy.Read(sPet);
		 * fluShotCopy.Read(sProcedure); System.out.println("\ntoString of dogCopy:\n" +
		 * dogCopy + "\nJSon of dogCopy:\n" + dogCopy.GetJSON()); System.out.println(
		 * "\ntoString of fluShotCopy:\n" + fluShotCopy + "\nJSon of fluShotCopy:\n" +
		 * fluShotCopy.GetJSON());
		 */

		// Feedback From Professor for Adjustments to the Homework
		/*
		 * Visit Constructor. Need to call new for each element of the VisitProcedure
		 * array in the constructor. Check slide 28 of the array slides. This error will
		 * cause NullPointerExceptions to occur if the array elements that did not have
		 * new called for them are used.
		 * 
		 * Write. Should write out the number of VisitProcedures to the output file just
		 * before writing the VisitProcedure data. The file that is generated should use
		 * the format detailed in the homework specifications.
		 * 
		 * GetByIndex. Should have code that declares and throws an
		 * ArrayIndexOutOfBoundsException. Check slide 46 of the Exceptions slides on
		 * Blackboard for an example.
		 */

	}

	/***
	 * This method tests the methods in the Procedure class
	 */
	@SuppressWarnings("unused")
	private void testProcedure() {
		Procedure fluShot = new Procedure();
		String testName = "Flu Shot";
		Double price = 340.75;
		fluShot.setName(testName);
		fluShot.setPrice(price);

		if (testName.equals(fluShot.getName())) {
			System.out.println("Procedure Get/Set Name: Pass");
		} else {
			System.out.println("Procedure Get/Set Name: Fail");
		}

		if (price.equals(fluShot.getPrice())) {
			System.out.println("Procedure Get/Set Price: Pass");
		} else {
			System.out.println("Procedure Get/Set Price: Fail");
		}

	}

	/***
	 * This method uses automated testing to test the methods in the Pet class
	 */
	@SuppressWarnings("unused")
	private void testPet() {
		Pet dog = new Pet();
		String testName = "Luigi";
		String testSpecies = "Cockerspaniel";
		String testGender = "Male";
		dog.setName(testName);
		dog.setSpecies(testSpecies);
		dog.setGender(testGender);

		if (testName.equals(dog.getName())) {
			System.out.println("Pet Get/Set Name: Pass");
		} else {
			System.out.println("Pet Get/Set Name: Fail");
		}

		if (testSpecies.equals(dog.getSpecies())) {
			System.out.println("Pet Get/Set Species: Pass");
		} else {
			System.out.println("Pet Get/Set Species: Fail");
		}
		if (testGender.equals(dog.getGender())) {
			System.out.println("Pet Get/Set Gender: Pass");
		} else {
			System.out.println("Pet Get/Set Gender: Fail");
		}
	}

	@SuppressWarnings("resource")
	public void chooseUI(String[] args) {
		String str = "Choose UI " + "\n---------" + "\n1 - VisitProcedureConsoleUI" + "\n2 - VisitConsoleUI"
				+ "\n3 - VetGraphicalUI" + "\n4 - Exit" + "\n\nEnter Choice: ";
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println(str);
			int choice = s.nextInt();
			System.out.println("");
			if (choice == 1) {
				VisitProcedureConsoleUI vpci = new VisitProcedureConsoleUI();
				vpci.ShowUI();
			} else if (choice == 2) {
				VisitConsoleUI vcui = new VisitConsoleUI();
				vcui.ShowUI();
			} else if (choice == 3) {
				System.out.println("Please Wait For Application To Load...");
				VetGraphicalUI vgui = new VetGraphicalUI();
				vgui.ShowUI(args);
			} else if (choice == 4) {
				System.out.println("Ending the program...");
				System.exit(0);
			}
		}
	}

}
