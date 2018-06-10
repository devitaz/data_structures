//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L9
// Class: CS260			     Lab #: 9
// Class time: 10:00am
// Date: 5/30/2014
// Program Name: QuickSort.java
// Program Description:	Quick Sort methods
//***************************************************************************
import java.util.*;

public class QuickSort
{
	private static Random gen = new Random();
	private static int swap = 0;

	/*
	*	public void QuickSort(int[] unsortedArray, int left, int right, boolean isMedOf3)
	Initializes QuickSort method to sort array from smallest integer value to largest.
	Parameters:	unsortedArray - the array that will be sorted
				left - the smallest index of the array
				right - the largest index of the array
				isMedOf3 - boolean value which identifies whether a median of 3 or 5 will
							be used to determine the pivotIndex
	Precondition:	there are more than 1 element in array
	Postcondition:	Array has been sorted from smallest to largest
	*/
	public void QuickSort(int[] unsortedArray, int left, int right, boolean isMedOf3)
	{

		int pivotIndex;
		int tooBig = left;
		int tooSmall = right;

		if(left < right)
		{
			if(isMedOf3)
				pivotIndex = MedianOfThree(unsortedArray, left, right);
			else
				pivotIndex = MedianOfFive(unsortedArray, left, right);

			int pivot = unsortedArray[pivotIndex];

			while(tooBig < tooSmall)
			{
				while(tooBig < pivotIndex && unsortedArray[tooBig] <= pivot)
					tooBig++;

				while(tooSmall > pivotIndex && unsortedArray[tooSmall] >= pivot)
					tooSmall--;

				if(tooBig < tooSmall)
				{
					swap++;
					if(tooBig == pivotIndex)
						pivotIndex = tooSmall;
					else if(tooSmall == pivotIndex)
						pivotIndex = tooBig;
					int temp = unsortedArray[tooBig];
					unsortedArray[tooBig] = unsortedArray[tooSmall];
					unsortedArray[tooSmall] = temp;
				}
			}
			QuickSort(unsortedArray, left, pivotIndex - 1, isMedOf3);
			QuickSort(unsortedArray, pivotIndex + 1, right, isMedOf3);
		}
	}
	/*
	*	private static int MedianOfThree(int[] a, int first, int last)
	Determines the median value of three randomly selected indexes from an array.
	Parameters:	a - the array which a median will be selected from
				first - the smallest index of the array
				last - the largest index of the array
	Returns:	the median value of the 3 selected array indexes
	*/
	private static int MedianOfThree(int[] a, int first, int last)
	{
		int one = gen.nextInt(last-first)+first;
		int two = gen.nextInt(last-first)+first;
		int three = gen.nextInt(last-first)+first;
		int[] temp = {a[one], a[two], a[three]};

		Arrays.sort(temp);

		if(temp[1] == a[one])
			return one;
		else if(temp[1] == a[two])
			return two;
		return three;
	}
	/*
	*	private static int MedianOfFive(int[] a, int first, int last)
	Determines the median value of five randomly selected indexes from an array.
	Parameters:	a - the array which a median will be selected from
				first - the smallest index of the array
				last - the largest index of the array
	Returns:	the median value of the 5 selected array indexes
	*/
	private static int MedianOfFive(int[] a, int first, int last)
	{
		int one = gen.nextInt(last-first)+first;
		int two = gen.nextInt(last-first)+first;
		int three = gen.nextInt(last-first)+first;
		int four = gen.nextInt(last-first)+first;
		int five = gen.nextInt(last-first)+first;
		int[] temp = {a[one], a[two], a[three], a[four], a[five]};

		Arrays.sort(temp);

		if(temp[2] == a[one])
			return one;
		else if(temp[2] == a[two])
			return two;
		else if(temp[2] == a[three])
			return three;
		else if(temp[2] == a[four])
			return four;
		return five;
	}
	/*
	*	public int getSwap()
	Accessor method that returns the number of swaps which occured.
	Returns:	the current number of swaps which have occured
	*/
	public int getSwap()
	{
		return swap;
	}
}