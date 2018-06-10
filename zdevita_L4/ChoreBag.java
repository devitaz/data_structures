//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L4
// Class: CS260			     Lab #: 4
// Class time: 10:00am
// Date: 4/23/2014
// Program Name: ChoreBag.java
// Program Description:	Driver class for chores list methods
//***************************************************************************
import java.util.*;
import java.io.*;

public class ChoreBag
{
	public static void main(String[] args) throws java.io.IOException
	{
		int count = 0, choreNum;
		char select, quit = '|';
		String newChore, tempChore;
		FileWriter fw = null;
		BufferedWriter bw = null;

		//	Create two scanners for input and to read from file
		Scanner userInput = new Scanner(System.in);
		Scanner fileScan = null;

		//	Constructor for a generic array bag
		//	Tests constructor method
		GenericBag<String> myChores = new GenericBag<String>();

		//	Create File and implements Scanner to read from it
		try
		{
			File myFile = new File("choreList.txt");
			fileScan = new Scanner(myFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File is not found in specified location");
		}

		//	Create File to write a final list to (save file)
		File savedFile = new File("finalChoreList.txt");
		if(!savedFile.isFile())
		{
			savedFile.mkdir();
			savedFile.createNewFile();
		}
		fw = new FileWriter(savedFile);
		bw = new BufferedWriter(fw);

		//	Loop to read each line of file and save to array bag
		//	Tests add() method
		while(fileScan.hasNext())
		{
			String line = fileScan.nextLine();
			myChores.add(line);
		}
		fileScan.close();

		// 	Prints initial list of elements in array bag
		//	Tests printList() method
		System.out.println("\n\n  Chore List\n---------------------------------------------");
		myChores.printList();

		//	Displays menu with options to select from for the user
		while(quit != 'q')
		{
			System.out.println("\n  Menu\n---------------------------------------------");
			System.out.println(" Select from the following options.\n");
			System.out.println("  (V)iew current list of chores.");
			System.out.println("  (T)otal number of chores on list.");
			System.out.println("  (A)dd a chore to the list.");
			System.out.println("  (R)emove a chore from the list.");
			System.out.println("  (E)xit and save list.");
			System.out.print("\n  ___\b\b");

			select = userInput.next().charAt(0);
			select = Character.toUpperCase(select);
			System.out.println("\n");

		//	Switch statement with corresponding block executed depending on user selection
			switch(select)
			{

		//	Adds chore (String) to array bag via user input
		//	Tests both add() method and pause() method
				case 'A':
					System.out.println(" Enter a new chore to add to the list:\n");
					System.out.print(" _____________________________________________\b\b\b\b\b\b\b\b\b\b\b\b");
					System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
					Scanner addChore = new Scanner(System.in);
					myChores.add(addChore.nextLine());
					GenericBag.pause();
					break;

		//	Displays number of elements currently in the array bag
		//	Tests both size() method and pause() method
				case 'T':
					System.out.println(" There are " + myChores.size() + " chores\n currently in the list.");
					GenericBag.pause();
					break;

		//	Displays current current elements in array bag
		//	Tests both printList() method and pause() method
				case 'V':
					System.out.println(" Chore List\n--------------------------------------------------.");
					myChores.printList();
					GenericBag.pause();
					break;

		//	Removes the element from the array bag that is selected by the user
		//	Tests remove(), printList(), isCurrent(), start(), advance() and pause() methods
				case 'R':
					myChores.printList();
					if(!myChores.isCurrent())
					{
						System.out.println("There are no current items in list.\n\n");
						break;
					}
					System.out.print("\nWhich chore would you like to remove?\nSelect the corresponding number.___\b\b");
					choreNum = userInput.nextInt();
					myChores.start();
					for(int i = 0; i < choreNum-1; i++)
						myChores.advance();
					myChores.remove(myChores.getCurrent());
					GenericBag.pause();
					break;

		//	Exits the program and saves all elements in array bag to text file
		//	Tests start(), advance(), isCurrent() and size() methods
				case 'E':
					System.out.println(" Your new list has been saved.\n Program will now exit.");
					myChores.start();
					for(int i = 0; (myChores.isCurrent()) && (i < myChores.size()); i++)
					{
						bw.write((i+1) + ".  " + myChores.getCurrent());
						bw.newLine();
						myChores.advance();
					}
					bw.close();
					fw.close();
					quit = 'q';
					System.out.println("\n\n");
					break;
		// If incorrect input is entered by user, prints message and loops back to menu
				default:
					System.out.println("Must enter either V, T, A, R or E, whichever\ncorresponds to your choice.");
					System.out.println("Try again.");
			}
		}
	}
}