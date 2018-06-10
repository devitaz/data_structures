//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L5
// Class: CS260			     Lab #: 5
// Class time: 10:00am
// Date: 5/8/2014
// Program Name: LinkedQueue.java
// Program Description:	Methods for generic Linked List Queue
//***************************************************************************
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class LinkedQueue<E> implements Cloneable
{
	private int count;
	private Node<E> front;
	private Node<E> rear;

	public LinkedQueue()
	{
		front = null;
		rear = null;
	}

	public void add(E item)
	{
		if(isEmpty())
		{
			front = new Node<E>(item, null);
			rear = front;
		}
		else
		{
			rear.addNodeAfter(item);
			rear = rear.getLink();
		}
		count++;
	}

	public LinkedQueue<E> clone()
	{
		Node[] cloneInfo;
		LinkedQueue<E> answer;

		try
		{
			answer = (LinkedQueue<E>) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new RuntimeException("This class does not implement Cloneable");
		}

		cloneInfo = Node.listCopyWithTail(front);
		answer.front = cloneInfo[0];
		answer.rear = cloneInfo[1];
		return answer;
	}

	public boolean isEmpty()
	{
		return (count == 0);
	}

	public E remove()
	{
		E answer;

		if(count == 0)
			throw new NoSuchElementException("Queue underflow.");
		answer = front.getData();
		front = front.getLink();
		count--;
		if(count == 0)
			rear = null;
		return answer;
	}

	public int size()
	{
		return count;
	}
}