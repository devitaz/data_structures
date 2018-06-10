//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L1
// Class: CS260			     Lab #: 1
// Class time: 10:00am
// Date: 4/2/2014
// Program Name: StatMain.java
// Program Description: Driver Class - Tests methods from Statistician.java
//***************************************************************************
import java.util.*;

public class StatMain
{
	public static void main(String[] args)throws YouFailedException
	{
		final double MAX = 25;
		double randNum;

		Random gen = new Random();
		Statistician set1 = new Statistician();
		Statistician set2 = new Statistician();

		for(int i = 0; i < 15; i++)
			set1.nextNumber(gen.nextDouble()*MAX);

		System.out.println("\n\n");
		System.out.println("First Sequence");
		System.out.println("Sequence Length: " + set1.seqLength());
		System.out.println("Last Number: " + set1.lastNum());
		System.out.println("Sum of Numbers: " + set1.sumOfNums());
		System.out.println("The Average: " + set1.seqAverage());
		System.out.println("Smallest Number: " + set1.smallNum());
		System.out.println("Largest Number: " + set1.largeNum());

		System.out.println("\n\n");

		for(int j = 0; j < 25; j++)
			set2.nextNumber(gen.nextDouble()*MAX);

		System.out.println("Second Sequence");
		System.out.println("Sequence Length: " + set2.seqLength());
		System.out.println("Last Number: " + set2.lastNum());
		System.out.println("Sum of Numbers: " + set2.sumOfNums());
		System.out.println("The Average: " + set2.seqAverage());
		System.out.println("Smallest Number: " + set2.smallNum());
		System.out.println("Largest Number: " + set2.largeNum());
		System.out.println("\n\n\n");
	}
}