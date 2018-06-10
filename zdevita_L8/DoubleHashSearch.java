//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L8
// Class: CS260			     Lab #: 8
// Class time: 10:00am
// Date: 5/23/2014
// Program Name: DoubleHashSearch.java
// Program Description:	Driver class for creating a Double Hash Search
//***************************************************************************
import java.util.*;
import java.io.*;

public class DoubleHashSearch
{
	public static void main(String[] args) throws IOException
	{
		//	Creates file and scanner objects necessary to read from file
		File myFile = new File("Employees.txt");
		Scanner fileScan = new Scanner(myFile);
		Scanner lineScan = null;

		//	Constructs a hash table of 51 elements and an object from Person class
		Table<Integer, Person> EmployeeHash = new Table<Integer, Person>(51);
		Person employee;

		//	Reads each line of the file
		while(fileScan.hasNext())
		{
		//	Seperates each line of the file by "tab" delimiter
			String line = fileScan.nextLine();
			lineScan = new Scanner(line);
			lineScan.useDelimiter("\t");

		//	Saves each individual String in the line to a variable
			String lastName = lineScan.next();
			String firstName = lineScan.next();
			String tempAge = lineScan.next();
			String tempID = lineScan.next();

		//	Parses age and IDNumber to integers
			int age = Integer.parseInt(tempAge);
			int IDNumber = Integer.parseInt(tempID);

		//	Instantiates Person objects with Strings from line
			employee = new Person(lastName, firstName, age, IDNumber);

		//	Inserts each Person object into an element of the hash table
			EmployeeHash.put(employee.getID(), employee);
		}
		//	Prints the total number of collisions that occured
		System.out.println("\nNumber of Collisions: " + EmployeeHash.getCollisions());

		//	Prints entire hash table in order of array index
		System.out.println("\n::::::::::: Table :::::::::::::::::::::");
		System.out.println("Index#\tFirst\tLast\tAge\tID#");
		System.out.println("---------------------------------------");
		for(int i = 0; i < EmployeeHash.getCapacity(); i++)
		{
			if(EmployeeHash.getData(i) == null)
				System.out.println(i +"\t-\t-\t-\t-");
			else
			{
				System.out.print(i + "\t" + EmployeeHash.getData(i).getFirst());
				System.out.print("\t" + EmployeeHash.getData(i).getLast());
				System.out.print("\t" + EmployeeHash.getData(i).getAge()+"\t");
				System.out.println(EmployeeHash.getData(i).getID());
			}
		}
		//	Testing the get() function by searching for employees by their IDNumbers
		// 	Person p1, p2, & p3 exist but Person p4 & p5 do not exist
		Person p1 = EmployeeHash.get(8094820);
		System.out.println();
		if(p1 != null)
			System.out.println("Search 1: " + p1.getFirst() + " " + p1.getLast());

		System.out.println();
		Person p2 = EmployeeHash.get(8603263);
		if(p2 != null)
			System.out.println("Search 2: " + p2.getFirst() + " " + p2.getLast());

		System.out.println();
		Person p3 = EmployeeHash.get(8023416);
		if(p3 != null)
			System.out.println("Search 3: " + p3.getFirst() + " " + p3.getLast());

		System.out.println();
		Person p4 = EmployeeHash.get(8000000);
		if(p4 != null)
			System.out.println("Search 4: " + p4.getFirst() + " " + p4.getLast());

		System.out.println();
		Person p5 = EmployeeHash.get(8000001);
		if(p5 != null)
			System.out.println("Search 5: " + p5.getFirst() + " " + p5.getLast());

		System.out.println("\n\n");
	}
}