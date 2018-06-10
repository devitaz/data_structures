//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L8
// Class: CS260			     Lab #: 8
// Class time: 10:00am
// Date: 5/23/2014
// Program Name: Person.java
// Program Description:	Class that holds employee Information as objects
//***************************************************************************

public class Person
{
	private String first, last;
	private int age;
	private int idNumber;

/*
*	public Person(String lName, String fName, int yearsOld, int number)
Initializes an object of Person with the specified attributes.
Parameters:	lName - the last name of the person
			fName - the first name of the person
			yearsOld - the age of the person
			number - the ID Number of the person
Postcondition:	An object of Person has been created with specified attributes
*/
	public Person(String lName, String fName, int yearsOld, int number)
	{
		first = fName;
		last = lName;
		age = yearsOld;
		idNumber = number;
	}
/*
*	public String getLast()
Accessor method which returns the last name of the Person object.
Returns:	returns the last name of the Person object
*/
	public String getLast()
	{
		return last;
	}
/*
*	public String getFirst()
Accessor method which returns the first name of the Person object.
Returns:	returns the first name of the Person object
*/
	public String getFirst()
	{
		return first;
	}

/*
*	public int getAge()
Accessor method which returns the age of the Person object.
Returns:	returns the age of the Person object
*/
	public int getAge()
	{
		return age;
	}
/*
*	public int getID()
Accessor method which returns the ID Number of the Person object.
Returns:	returns the ID Number of the Person object
*/
	public int getID()
	{
		return idNumber;
	}
}