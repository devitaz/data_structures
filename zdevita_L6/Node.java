//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L4
// Class: CS260			     Lab #: 4
// Class time: 10:00am
// Date: 4/30/2014
// Program Name: Node.java
// Program Description:	Methods for generic Linked list
//***************************************************************************
import java.util.*;

@SuppressWarnings("unchecked")
public class Node<E>
{
	private E data;
	private Node<E> link;

/*
*	public IntNode(int initialData, IntNode initialLink)
Initialize a node with specified initial data and a link to the next node.
Parameters:	initialData - the initial data of this new node
			initialLink - a reference to the node after this new node
Postcondition:	This new node contains the specified data and a link to the next node
*/
	public Node(E initialData, Node initialLink)
	{
		data = initialData;
		link = initialLink;
	}
/*
*	public void addNode(int element, IntNode headNode)
Modification method to add a new node after head node and with specified data
Parameters:	element - the data to be placed in the new node
			headNode - the head node, where to place the new node being created
Postcondition - A new node has been created and placed after the head node. The data for the new node is
				element. Any other nodes that used to be after this node are now after the new node.
*/
	public void addNode(E element, Node headNode)
	{
		try
		{
			Node newNode = new Node(element, headNode);
			newNode.link = link;
			link = newNode;
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("There is insufficient memory to create a new node");
		}
	}
/*
*	public void addNodeAfter(int element)
Modification method to add a new node after this node
Parameter:	element - the data to be placed in the new node
Postcondition:	A new node has been created and placed after this node. The data for the new node is
				element. Any other nodes that used to be after this node are now after the new node.
*/
	public void addNodeAfter(E element)
	{
		try
		{
			link = new Node(element, link);
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("There is insufficient memory to create a new node");
		}
	}
/*
*	public void removeNodeAfter()
Modification method to remove the node after this node.
Precondition:	This node must not be the tail node of the list
Postcondition:	The node after this node has been removed from the linked list. If there were further
				nodes after that one, they are still present in the list.
*/
	public void removeNodeAfter()
	{
		link = link.link;
	}
/*
*	public static Node listCopy(Node source)
Copy a list
Parameter:	source - the head reference for a linked list that will be copied
Returns:	The method has made a copy of the linked list starting at source. The return value is the
			head reference for the copy
*/
	public static Node listCopy(Node source)
	{
		Node copyHead;
		Node copyTail;

		if(source == null)
			return null;

		copyHead = new Node(source.data, null);
		copyTail = copyHead;

		while(source.link != null)
		{
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		return copyHead;
	}

	public static Node[] listCopyWithTail(Node source)
	{
		Node copyHead;
		Node copyTail;
		Node[] answer = new Node[2];

		if(source == null)
			return answer;

		copyHead = new Node(source.data, null);
		copyTail = copyHead;

		while(source.link != null)
		{
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}
/*
*	public static int listLength(IntNode head)
Compute the number of nodes in a linked list.
Parameter:	head - the head reference for a linked list
Returns:	the number of nodes in the list with the given head
*/
	public static int listLength(Node head)
	{
		Node cursor;
		int answer;

		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
			answer++;

		return answer;
	}
/*
*	public int getData()
Accessor method to get the data from this node
Returns:	the data from this node
*/
	public E getData()
	{
		return data;
	}
/*
*	public IntNode getLink()
Accessor method to get a reference to the next node after this node.
Returns:	a reference to the node after this node
*/
	public Node getLink()
	{
		return link;
	}
/*
*	public void setData(int newData)
Modification method to set the data in this node
Parameter:	newData - the new data to place in this node
Postcondition:	The data of this node has been set to newData
*/
	public void setData(E newData)
	{
		data = newData;
	}
/*
*	public void setLink(IntNode newLink)
Modification method to set the reference to the next node after this node.
Parameter:	newLink - a reference to the node that should appear after this node in the linked list
Postcondition:	The link to the node after this node has been set to newLink. Any other node is no
				longer connected to this node.
*/
	public void setLink(Node newLink)
	{
		link = newLink;
	}
}