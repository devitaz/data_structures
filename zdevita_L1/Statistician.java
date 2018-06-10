//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L1
// Class: CS260			     Lab #: 1
// Class time: 10:00am
// Date: 4/2/2014
// Program Name: Statistician.java
// Program Description: Methods which do various operations to series of numbers
//***************************************************************************

public class Statistician
{
	private final double MAX = 50, MIN = -50;
	private int count = 0;
	private double sum = 0, myDouble = 0, small = 999999, large = -999999;
/*
* 	public void nextNumber(double num)
Adds next double to the sequence of numbers.
Parameter:	num - the double that has been added to the sequence
Precondition:	num > MIN(-50)and num < MAX(50)
Postcondition:	num has been added to sequence, sum has been incremented by num, findMaxMin()
				has been called with num as a parameter, and count has been incremented.
*/
	public void nextNumber(double num)throws YouFailedException
	{
		if(num<MIN || num>MAX)
			throw new YouFailedException("Double must be between -50 and 50");
		else
		{
			myDouble = num;
			sum += myDouble;
			findMaxMin(myDouble);
			count++;
		}
	}
/*
*	public int seqLength()
Get the current number of doubles in the sequence.
Returns:	count - the total number of doubles that have been added to sequence
*/
	public int seqLength()
	{
		return count;
	}
/*
*	public double lastNum()
Get the last double added to the sequence.
Returns:	myDouble - the last double called by nextNumber() method.
*/
	public double lastNum()
	{
		return myDouble;
	}
/*
*	public double sumOfNums()
Get the total sum of all numbers in the sequence.
Returns:	sum - the sum of all numbers in the sequence
*/
	public double sumOfNums()
	{
		return sum;
	}
/*
*	public double seqAverage()
Get the average of all numbers in the sequence.
Returns:	the current sum of all numbers in the sequence divided by the current
			number of elements in the sequence. (sum/count)
*/
	public double seqAverage()
	{
		return sum/count;
	}
/*
*	public double smallNum()
Get the smallest number in the sequence.
Returns:	small - the number in the sequence with the lowest value
*/
	public double smallNum()
	{
		return small;
	}
/*
*	public double largeNum()
Get the largest number in the sequence.
Returns:	large - the number in the sequence with the greatest value
*/
	public double largeNum()
	{
		return large;
	}
/*
*	public void findMaxMin(double comparable)
compares two numbers to find which one is smaller and which one is larger
Parameter:	comparable - the double which will be compared to both doubles large and small
Postcondition:	If comparable is greater than large, then the value in large is replaced
				with comparable. If comparable is less than small, then the value in small
				is replaced with comparable.
*/
	public void findMaxMin(double comparable)
	{
		if(comparable > large)
			large = comparable;
		if(comparable < small)
			small = comparable;
	}
}
class YouFailedException extends Exception
{
	YouFailedException(String message)
	{
		super(message);
	}
}
