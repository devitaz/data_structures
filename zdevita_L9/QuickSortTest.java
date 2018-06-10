//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L9
// Class: CS260			     Lab #: 9
// Class time: 10:00am
// Date: 5/30/2014
// Program Name: QuickSortTest.java
// Program Description:	Driver class for testing quicksort methods
//***************************************************************************
import java.util.*;

public class QuickSortTest
{
	public static void main(String[] args)
	{
		QuickSort qs = new QuickSort();

		int[] sorted = new int[50];
		int[] reverse = new int[50];
		int[] random = {28, 46, 2, 26, 11, 23, 9, 25, 39, 47, 29, 31, 10,
						4, 40, 3, 42, 21, 6, 38, 22, 8, 41, 18, 27, 33, 45,
						30, 1, 24, 36, 43, 14, 17, 49, 19, 44, 34, 5, 37,
						32, 48, 16, 50, 35, 12, 15, 7, 20, 13};

//	This fills the sorted and reverse arrays with sorted and reverse values 1 - 50
		for(int i = 0; i < 50; i++)
		{
			sorted[i] = i + 1;
			reverse[i] = 50 - i;
		}
//	Random Array - Median of 3
		int[] temp = random;
		System.out.println("\nRandom Array - Median of 3");
		System.out.println("-------------------------------------------------");
		qs.QuickSort(temp, 0, temp.length-1, true);
		for(int i = 0; i < temp.length-1; i++)
		{
			if(i < 9)
				System.out.print(temp[i] + "   ");
			else
				System.out.print(temp[i] + "  ");
			if(i != 0 && i%16 == 0)
				System.out.println("\n");
		}
		System.out.println("Number of Swaps: " + qs.getSwap());
//	This resets the random array to the exact initial random configuration
		temp = random;

//	Random Array - Median of 5
		System.out.println("\nRandom Array - Median of 5");
		System.out.println("-------------------------------------------------");
		qs.QuickSort(temp, 0, temp.length-1, false);
		for(int i = 0; i < temp.length-1; i++)
		{
			if(i < 9)
				System.out.print(temp[i] + "   ");
			else
				System.out.print(temp[i] + "  ");
			if(i != 0 && i%16 == 0)
				System.out.println("\n");
		}
		System.out.println("Number of Swaps: " + qs.getSwap());
//	Sorted Array - Median of 3
		System.out.println("\nSorted Array - Median of 3");
		System.out.println("-------------------------------------------------");
		qs.QuickSort(sorted, 0, sorted.length-1, true);
		for(int i = 0; i < sorted.length-1; i++)
		{
			if(i < 9)
				System.out.print(sorted[i] + "   ");
			else
				System.out.print(sorted[i] + "  ");
			if(i != 0 && i%16 == 0)
				System.out.println("\n");
		}
		System.out.println("Number of Swaps: " + qs.getSwap());

//	Sorted Array - Median of 5
		System.out.println("\nSorted Array - Median of 5");
		System.out.println("-------------------------------------------------");
		qs.QuickSort(sorted, 0, sorted.length-1, false);
		for(int i = 0; i < sorted.length-1; i++)
		{
			if(i < 9)
				System.out.print(sorted[i] + "   ");
			else
				System.out.print(sorted[i] + "  ");
			if(i != 0 && i%16 == 0)
				System.out.println("\n");
		}
		System.out.println("Number of Swaps: " + qs.getSwap());
//	Reverse Array - Median of 3
		System.out.println("\nReverse Array - Median of 3");
		System.out.println("-------------------------------------------------");
		qs.QuickSort(reverse, 0, reverse.length-1, true);
		for(int i = 0; i < reverse.length-1; i++)
		{
			if(i < 9)
				System.out.print(reverse[i] + "   ");
			else
				System.out.print(reverse[i] + "  ");
			if(i != 0 && i%16 == 0)
				System.out.println("\n");
		}
		System.out.println("Number of Swaps: " + qs.getSwap());
//	This resets the reverse array to the initial reverse configuration
		for(int i = 0; i < 50; i++)
			reverse[i] = 50 - i;

//	Reverse Array - Median of 5
		System.out.println("\nReverse Array - Median of 5");
		System.out.println("-------------------------------------------------");
		qs.QuickSort(reverse, 0, reverse.length-1, false);
		for(int i = 0; i < reverse.length-1; i++)
		{
			if(i < 9)
				System.out.print(reverse[i] + "   ");
			else
				System.out.print(reverse[i] + "  ");
			if(i != 0 && i%16 == 0)
				System.out.println("\n");
		}
		System.out.println("Number of Swaps: " + qs.getSwap());

		System.out.println("\n\n\n");
	}
}