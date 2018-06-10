//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L4
// Class: CS260			     Lab #: 4
// Class time: 10:00am
// Date: 4/23/2014
// Program Name: GenericBag.java
// Program Description:	Generic Bag methods
//***************************************************************************
import java.util.*;

public class GenericBag<E> implements Cloneable
{
	private Object[] data;
	private int count, currentIndex;
	private E value;

/*
*	public void GenericBag()
Initializes an empty array bag with an initial capacity of 10
Postcondition:	This array bag is empty and has an initial capacity of 10.
*/
	public GenericBag()
	{
		final int INITIAL_CAPACITY = 10;
		count = 0;
		try
		{
			data = new Object[INITIAL_CAPACITY];
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory to construct object");
		}
	}
/*
*	public void GenericBag(int initialCapacity)
Initializes an empty array bag with a specified initial capacity
Parameter:	initialCapacity - the initial capacity of this sequence
Precondition:	initialCapacity is non-negative
Postcondition:	This array bag is empty and has the given initial capacity.
*/
	public GenericBag(int initialCapacity)
	{
		count = 0;
		try
		{
			data = new Object[initialCapacity];
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
*	public void add(E element)
Adds a new element to GenericBag
Parameter:	element - the new element that is being added
Postcondition:	A new copy of the element has been added to this array bag
*/
	public void add(E element)
	{
		if(count == data.length)
			ensureCapacity(count*2 + 1);
		data[count] = element;
		count++;
	}
/*
*	public boolean remove(E target)
Remove the current element from this array bag.
Precondition:	isCurrent() returns true
Postcondition:	The current element has been removed from the array bag and all
				elements below are shifted up one element
*/
	public boolean remove(E target)
	{
		int index;

		if(target == null)
		{
			index = 0;
			while((index < count) && (data[index] != null))
				index++;
		}
		else
		{
			index = 0;
			while((index < count) && (!target.equals(data[index])))
				index++;
		}
		if(index == count)
			return false;
		else
		{
			count--;
			data[index] = data[count];
			data[count] = null;
			return true;
		}
	}
/*
*	public GenericBag<E> clone()
Generates a copy of this array bag.
Returns:	Returns a copy of this array bag. Changes to the copy will not affect
			original and vice-versa.
*/
	@SuppressWarnings("unchecked")
	public GenericBag<E> clone()
	{
		GenericBag<E> answer;

		try
		{
			answer =(GenericBag<E>) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new RuntimeException("This class does not implement Cloneable");
		}
		answer.data = data.clone();
		return answer;
	}
/*
*	public boolean equals(Object obj)
Compares two objects and determines whether they are equivalent
Parameter:	obj - the object which will be compared to
Precondition:	object must be an instance of GenericBag
Returns:	if object is an instance of GenericBag and both objects being compared
			are equal, then method returns true, otherwise method returns false.
*/
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj)
	{
		if((obj instanceof GenericBag<?>) && ((GenericBag<?>)obj).value.equals(value))
			return true;
		return false;
	}
/*
*	public void ensureCapacity(int minimumCapacity)
Change the current capacity of this array bag.
Parameter:	minimumCapacity - the new capacity for this array bag
Postcondition:	This array bag's capacity has been changed to at least minimumCapacity
*/
	public void ensureCapacity(int minimumCapacity)
	{
		try
		{
			Object[] bigArray = new Object[minimumCapacity];
			for(int i = 0; i < count; i++)
				bigArray[i] = data[i];
			data = bigArray;
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Insufficient memory for the ensureCapacity() call.");
		}
	}
/*
*	public void trimToSize()
Reduce the current capacity of this array bag to its actual size
Postcondition:	This array bag's capacity has been changed to its current size
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
Accessor method to determine the number of elements in this array bag.
Returns:	the number of elements in this array bag
*/
	public int size()
	{
		return count;
	}
/*
*	public void start()
Set the current element at the front of this array bag.
Postcondition:	The front element of this array bag is now the current element
*/
	public void start()
	{
		currentIndex = 0;
	}
/*
*	public void advance()
Move forward so that the current element is now the next element in this array bag
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
*	public E getCurrent()
Accessor method to determine the current element of this array bag.
Precondition:	isCurrent() returns true
Returns: the current element of this array bag
*/
	@SuppressWarnings("unchecked")
	public E getCurrent()
	{
		if(isCurrent())
			return (E)data[currentIndex];
		throw new IllegalStateException("There is no current element.");
	}
/*
*	public boolean isCurrent()
Accessor method to determine whether this array bag has a specified current
element that can be retrieved with the getCurrent() method.
Returns:	true(there is a current element) false(there is no current element)
*/
	public boolean isCurrent()
	{
		return (data[currentIndex] != 0) ? true:false;
	}
/*
*	public int getCapacity()
Accessor method to determine the current capacity of this array bag.
Returns:	the current capacity of this array bag
*/
	public int getCapacity()
	{
		return data.length;
	}
/*
*	public void printList()
Method which numbers and prints all elements of the array bag.
Precondition: isCurrent() returns true
Postcondition:	All elements of array bag are printed, one per line
*/
	public void printList()
	{
		start();
		for(int i = 0; (isCurrent()) && (i < size()); i++)
		{
			System.out.println((i+1) + ".  " + getCurrent());
			advance();
		}
	}
/*
*	public static void pause()
Static method which requires user to press enter to continue
Postcondition:	Program pauses and requires user to press enter to continue
*/
	public static void pause()
	{
		System.out.println("\n\n\nPress enter to continue...");
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
	}
}