//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L3
// Class: CS260			     Lab #: 3
// Class time: 10:00am
// Date: 4/14/2014
// Program Name: IntNode.java
// Program Description:	Linked list methods including a sort method
//***************************************************************************
public class IntNode
{
	private int data;
	private IntNode link;

/*
*	public IntNode(int initialData, IntNode initialLink)
Initialize a node with specified initial data and a link to the next node.
Parameters:	initialData - the initial data of this new node
			initialLink - a reference to the node after this new node
Postcondition:	This new node contains the specified data and a link to the next node
*/
	public IntNode(int initialData, IntNode initialLink)
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
	public void addNode(int element, IntNode headNode)
	{
		try
		{
			IntNode newNode = new IntNode(element, headNode);
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
	public void addNodeAfter(int element)
	{
		try
		{
			link = new IntNode(element, link);
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
*	public static int listLength(IntNode head)
Compute the number of nodes in a linked list.
Parameter:	head - the head reference for a linked list
Returns:	the number of nodes in the list with the given head
*/
	public static int listLength(IntNode head)
	{
		IntNode cursor;
		int answer;

		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
			answer++;

		return answer;
	}
/*
*	public IntNode listSort(IntNode head)
Modification method which constructs a new head node, then places nodes in order from smallest to largest.
Parameter:	head - the head reference for a linked list
Precondition:	head != null
Postcondition:	New head node created which has references to all original nodes but in ascending order
Returns:	Returns a sorted linked list with the same elements as the original
*/
	public IntNode listSort(IntNode head)
	{
		IntNode big = null, previous = null, temp = null, sorted = null, current = null;
		int num = 0, j = 0;
		int length = IntNode.listLength(head);

		if(head == null)
			return null;

		for(int i = 0; (head != null) && (i < length); i++)
		{
			for(IntNode cursor = head; (cursor != null) && (j < length); previous = cursor, cursor = cursor.link, j++)
			{
				if(cursor.data > num)
				{
					big = cursor;
					temp = previous;
					num = cursor.data;
				}
			}
			j = num = 0;
			sorted = new IntNode(big.data, sorted);
			//sorted = sorted.link;
			//sorted.setLink(temp.getLink());


			if(big.data == head.data)
				head = head.getLink();
			else
				temp.removeNodeAfter();
		}
		return sorted;
	}
/*
*	public int getData()
Accessor method to get the data from this node
Returns:	the data from this node
*/
	public int getData()
	{
		return data;
	}
/*
*	public IntNode getLink()
Accessor method to get a reference to the next node after this node.
Returns:	a reference to the node after this node
*/
	public IntNode getLink()
	{
		return link;
	}
/*
*	public void setData(int newData)
Modification method to set the data in this node
Parameter:	newData - the new data to place in this node
Postcondition:	The data of this node has been set to newData
*/
	public void setData(int newData)
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
	public void setLink(IntNode newLink)
	{
		link = newLink;
	}
}