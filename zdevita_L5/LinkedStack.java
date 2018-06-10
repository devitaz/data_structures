//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L4
// Class: CS260			     Lab #: 4
// Class time: 10:00am
// Date: 4/30/2014
// Program Name: LinkedStack.java
// Program Description:	Methods for generic Stack
//***************************************************************************
import java.util.*;
import java.lang.*;

@SuppressWarnings("unchecked")
public class LinkedStack<E> implements Cloneable
{
	private Node<E> top;

/*
*	public LinkedStack()
Initializes an empty stack.
Postcondition:	This stack is empty
*/
	public LinkedStack()
	{
		top = null;
	}
/*
*	public LinkedStack<E> clone()
Generates a copy of this stack.
Returns:	The return value is a copy of this stack. Subsequent changes to the copy will
			not affect the original or vice-versa
*/
	public LinkedStack<E> clone()
	{
		LinkedStack<E> answer;

		try
		{
			answer = (LinkedStack<E>) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new RuntimeException("This class does not implement Cloneable");
		}
		answer.top = Node.listCopy(top);
		return answer;
	}
/*
*	public boolean isEmpty()
Determines whether this stack is empty
Returns:	true if this stack is empty; otherwise false
*/
	public boolean isEmpty()
	{
		return (top == null);
	}
/*
*	public E peek()
Get the top item of this stack without removing the item.
Precondition:	This stack is not empty
Returns:	the top item of the stack
*/
	public E peek()
	{
		return top.getData();
	}
/*
*	public E pop()
Get the top item, removing it from this stack.
Precondition:	This stack is not empty
Postcondition:	The return value is the top item of stack, and the item is removed
*/
	public E pop()
	{
		E answer;

		if(top == null)
			throw new EmptyStackException();

		answer = top.getData();
		top = top.getLink();
		return answer;
	}
/*
*	public void push(E item)
Push a new item onto this stack. The new item may be the null reference.
Parameter:	item - the item to be pushed onto this stack
Postcondition:	The item has been pushed onto this stack
*/
	public void push(E item)
	{
		top = new Node<E>(item, top);
	}
/*
*	public int size()
Accessor method to determine the number of items in this stack.
Returns:	the number of items in this stack
*/
	public int size()
	{
		return Node.listLength(top);
	}
}