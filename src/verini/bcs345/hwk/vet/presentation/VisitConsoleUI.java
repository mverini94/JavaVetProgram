package verini.bcs345.hwk.vet.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import verini.bcs345.hwk.vet.business.*;

/**
 * 
 * 
 * @author mattverini
 * @version 1.0
 * @since 12/13/2018
 */
public class VisitConsoleUI {
	/**
	 * This method shows a menu that allows the user to read from a file and write
	 * to a file. Also shows visit procedure by index, visit procedure with the
	 * highest amount due, the report of the visit, and the visit procedure in a
	 * JSON or toString format
	 */
	@SuppressWarnings("resource")
	public void ShowUI() {
		Scanner s = new Scanner(System.in);
		Visit visit = new Visit();
		String str = "Visit UI" + "\n--------" + "\n1 - Read visit info from file" + "\n2 - Write visit info to file"
				+ "\n3 - Show visit procedure by index" + "\n4 - Show visit procedure with highest amount due"
				+ "\n5 - Show visit report on screen" + "\n6 - Show visit as JSON string on screen"
				+ "\n7 - Show visit toString on sreen" + "\n8 - Exit" + "\n\nEnter a choice: ";
		while (true) {
			System.out.println(str);
			int userInput = s.nextInt();
			switch (userInput) {
			case 1:
				Scanner s1 = new Scanner(System.in);
				System.out.println("Input the visit text file you would like to read from: ");
				String fileName = s1.nextLine();
				System.out.println("");
				try {
					visit.Read(new Scanner(new File(fileName)));
				} catch (FileNotFoundException e) {
					System.out.println("File was not found\n");
				}
				break;
			case 2:
				Scanner s2 = new Scanner(System.in);
				System.out.println("Input the visit text file you would like to write to: ");
				String outPutFileName = s2.nextLine();
				try {
					visit.Write(new PrintStream(outPutFileName));
					System.out.println("");
				} catch (FileNotFoundException e) {
					System.out.println("File was not found");
				}
				break;
			case 3:
				System.out.println("Input an index");
				int userIndexInput = s.nextInt();
				try {
					System.out.println("\n" + visit.GetByIndex(userIndexInput) + "\n");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("The index entered is not valid");
				}
				break;
			case 4:
				System.out.println("Visit Procedure with the highest amount due\n");
				System.out.println(visit.GetHighestProcedureAmountDue() + "\n");
				break;
			case 5:
				System.out.println("\n\n");
				visit.Report(System.out);
				System.out.println("\n\n");
				break;
			case 6:
				System.out.println("\n\n" + visit.GetJSON() + "\n\n");
				break;
			case 7:
				System.out.println("\n\n" + visit + "\n\n");
				break;
			case 8:
				System.out.println("\nReturn to the Original Menu...\n");
				//System.exit(0);
				//break;
				return;
			default:
				System.out.println("Please enter a number from 1-8");
				break;
			}
		}
	}
}
