package verini.bcs345.hwk.vet.presentation;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import verini.bcs345.hwk.vet.business.*;

/***
 * This class contains a menu that allows the user to read from a file, write
 * from a file, and display visit procedure information
 * 
 * @author mattverini
 * @version 1.0
 * @since 12/13/2018
 */

public class VisitProcedureConsoleUI {

	/**
	 * This method shows a menu that allows the user whether they want to read or
	 * write from a file. This method also allows the user to pick whether they want
	 * to display the VisitProcedure information or a JSON of the VisitProcedure
	 * class
	 * 
	 */
	@SuppressWarnings("resource")
	public void ShowUI() {
		VisitProcedure visitprocedure = new VisitProcedure();
		Scanner s = new Scanner(System.in);
		while (true) {

			System.out.println("Visit Procedure UI");
			System.out.println("------------------");
			System.out.println("1 - Read visit procedure from file");
			System.out.println("2 - Write visit procedure to file");
			System.out.println("3 - Show visit procedure data with descriptive text on screen");
			System.out.println("4 - Show visit procedure JSON on screen");
			System.out.println("5 - Exit");
			System.out.println("\nEnter Choice: ");
			try {
				int choice = s.nextInt();
				s.nextLine();
				if (choice == 1) {
					System.out.println("Input the Visit Procedure file name");
					String fileName = s.nextLine();
					try {
						Scanner read = new Scanner(new File(fileName));
						visitprocedure.Read(read);
						System.out.println("");
					} catch (FileNotFoundException e) {
						System.out.println("Sorry, file was not found.\n");
					}
				} else if (choice == 2) {
					System.out.println("What is the filename you wish to write to?");
					String fileName = s.nextLine();
					try {
						PrintStream ps = new PrintStream(fileName);
						visitprocedure.Write(ps);
						System.out.println("");
					} catch (FileNotFoundException e) {
						System.out.println("Sorry, file was not found.\n");
					}
				} else if (choice == 3) {
					System.out.println("\n" + visitprocedure + "\n");
				} else if (choice == 4) {
					System.out.println("\n" + visitprocedure.GetJSON() + "\n");
				} else if (choice == 5) {
					System.out.println("\nReturn to the Original Menu...\n");
					//s.close();
					//System.exit(0);
					break;
				}
			} catch (InputMismatchException ime) {
				String err = s.next();
				System.err.println("Please input numbers 1 - 5 only");
				System.err.println(err + ": is not a number\n");
				continue;
			}

		}

	}

}
