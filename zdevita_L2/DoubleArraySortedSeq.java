//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L2
// Class: CS260			     Lab #: 2
// Class time: 10:00am
// Date: 4/6/2014
// Program Name: DoubleArraySortedSeq.java
// Program Description:
//***************************************************************************
import java.util.*;

public class DoubleArraySortedSeq implements Cloneable
{
	private int count = 0, currentIndex;
	private double[] data;

/*
*	public void DoubleArraySortedSeq()
Initializes an empty sequence with an initial capacity of 10
Postcondition:	This sequence is empty and has an initial capacity of 10.
*/
	public void DoubleArraySortedSeq()
	{
		try
		{
			data = new double[10];
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory to construct object");
		}
	}
/*
*	public void DoubleArraySortedSeq(int arraySize)
Initializes an empty sequence with a specified initial capacity
Parameter:	arraySize - the initial capacity of this sequence
Precondition:	arraySize is non-negative
Postcondition:	This sequence is empty and has the given initial capacity.
*/
	public void DoubleArraySortedSeq(int arraySize)
	{
		try
		{
			data = new double[arraySize];
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("arraySize cannot be negative");
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory to construct object");
		}
	}
/*
*	public void add(double target)
Adds a new element to sequence in sorted order.
Parameter:	target - the new element that is being added
Postcondition:	A new copy of the element has been added to this sequence in sorted order
*/
	public void add(double target)
	{
		if(size() == data.length)
			ensureCapacity(data.length*2);
		start();
		while(isCurrent() && getCurrent() < target)
			advance();
		try
		{
			for(int index = count; index > currentIndex; index--)
				data[index] = data[index-1];
			data[currentIndex] = target;
			count++;
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory to increase the size of this sequence.");
		}
	}
/*
*	public void addAll(DoubleArraySortedSeq addend)
Place the contents of another sequence at the end of this sequence
Parameter:	addend - a sequence whose contents will be placed at the end of this sequence
Precondition:	The parameter, addend, is not null
Postcondition:	The elements from addend have been placed at the end of this sequence
*/
	public void addAll(DoubleArraySortedSeq addend)
	{
		try
		{	addend.start();
			for(int i = 0; i < addend.size(); i++)
			{
				add(addend.getCurrent());
				addend.advance();
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Sequence being added is null.");
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory to increase the size of this sequence.");
		}
	}
/*
*	public boolean search(double target)
Determines whether specified double is in sequence
Parameter:	target - the double which is being searched for
Returns:	true if double is located in sequence, false if it is not
*/
	public boolean search(double target)
	{
		for(int i = 0; i < size(); i++)
			if(data[i] == target)
				return true;
		return false;
	}
/*
*	public void advance()
Move forward so that the current element is now the next element in this sequence
Precondition:	isCurrent() returns true
Postcondition:	New element is the element immediately after the original current element.
				If current element was the end element, there is no longer a current element.
*/
	public void advance()
	{
		try
		{
			if(isCurrent())
				currentIndex++;
		}
		catch(IllegalStateException e)
		{
			System.out.println("There is no current element so advance may not be called.");
		}
	}
/*
*	public void ensureCapacity(int minimumCapacity)
Change the current capacity of this sequence.
Parameter:	minimumCapacity - the new capacity for this sequence
Postcondition:	This sequence's capacity has been changed to at least minimumCapacity
*/
	public void ensureCapacity(int minimumCapacity)
	{
		try
		{
			double[] tempArray = new double[minimumCapacity];
			for(int i = 0; i < count; i++)
				tempArray[i] = data[i];
			data = tempArray;
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory for the ensureCapacity() call.");
		}
	}
/*
*	public boolean removeCurrent()
Remove the current element from this sequence.
Precondition:	isCurrent() returns true
Postcondition:	The current element has been removed from sequence and all elements
				below are shifted up one element
*/
	public boolean removeCurrent()
	{
		try
		{
			if(isCurrent())
			{
				for(int i = currentIndex; i+1 < data.length; i++)
					data[i] = data[i+1];
				count--;
				return true;
			}
		}
		catch(IllegalStateException e)
		{
			System.out.println("There is no current element.");
		}
		return false;
	}
/*
*	public DoubleArraySortedSeq clone()
Generates a copy of this sequence.
Returns:	Returns a copy of this sequence. Changes to the copy will not affect original
			and vice-versa.
*/
	public DoubleArraySortedSeq clone()
	{
		DoubleArraySortedSeq copy = new DoubleArraySortedSeq();
		copy.DoubleArraySortedSeq(getCapacity());
		try
		{
			copy = (DoubleArraySortedSeq)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		return copy;
	}
/*
*	public static DoubleArraySortedSeq concat(DoubleArraySortedSeq b1, DoubleArraySortedSeq b2)
Creates a new sequence that contains all the elements from one sequence followed by another
Parameters:	s1 - the first of two sequences
			s2 - the second of two sequences
Precondition:	Neither s1 nor s2 is null
Returns:	a new sequence that has the elements of s1 followed by the elements of s2
*/
	public static DoubleArraySortedSeq concat(DoubleArraySortedSeq b1, DoubleArraySortedSeq b2)
	{
		DoubleArraySortedSeq concatination = (DoubleArraySortedSeq)b1.clone();
		try
		{
			concatination.ensureCapacity(b1.getCapacity()+b2.getCapacity());
			concatination.addAll(b2);
		}
		catch(NullPointerException e)
		{
			System.out.println("One of the two arguments is null.");
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory for the concat().");
		}
		return concatination;
	}
/*
*	public void trimToSize()
Reduce the current capacity of this sequence to its actual size
Postcondition:	This sequence's capacity has been changed to its current size
*/
	public void trimToSize()
	{
		try
		{
			ensureCapacity(size());
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory for altering the capacity.");
		}
	}
/*
*	public int size()
Accessor method to determine the number of elements in this sequence.
Returns:	the number of elements in this sequence
*/
	public int size()
	{
		return count;
	}
/*
*	public void start()
Set the current element at the front of this sequence.
Postcondition:	The front element of this sequence is now the current element
*/
	public void start()
	{
		currentIndex = 0;
	}
/*
*	public double getCurrent()
Accessor method to determine the current element of this sequence.
Precondition:	isCurrent() returns true
Returns: the current element of this sequence
*/
	public double getCurrent()
	{
		if(isCurrent())
			return data[currentIndex];
		throw new IllegalStateException("There is no current element.");
	}
/*
*	public boolean isCurrent()
Accessor method to determine whether this sequence has a specified current
element that can be retrieved with the getCurrent() method.
Returns:	true(there is a current element) false(there is no current element)
*/
	public boolean isCurrent()
	{
		return (data[currentIndex] != 0) ? true:false;
	}
/*
*	public int getCapacity()
Accessor method to determine the current capacity of this sequence.
Returns:	the current capacity of this sequence
*/
	public int getCapacity()
	{
		return data.length;
	}
}