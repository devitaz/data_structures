//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L3
// Class: CS260			     Lab #: 3
// Class time: 10:00am
// Date: 4/14/2014
// Program Name: SortedNode.java
// Program Description:	Driver class for Linked list methods
//***************************************************************************
import java.util.*;

public class SortedNode
{
	public static void main(String[] args)
	{
		int count = 1;
		IntNode sortedNode;

		//	Testing constructor method
		IntNode head = new IntNode(85, null);
		head = new IntNode(321, head);
		head = new IntNode(4,head);
		head = new IntNode(9, head);
		head = new IntNode(8590, head);
		head = new IntNode(85, head);

		//	Testing getLink() and getData() methods
		System.out.println("\nIntegers in Linked List are\n-------------------------------------------");
		for(IntNode cursor = head; cursor != null; count++, cursor = cursor.getLink())
			System.out.println("Element in node " + count + ":  " + cursor.getData());

		//	Testing listLength() method
		System.out.println("\n\nTotal number of nodes: " + IntNode.listLength(head));

		//	Testing listSort() method
		sortedNode = head.listSort(head);

		count = 1;
		System.out.println();
		System.out.println("\nIntegers in Linked List after sort are\n-------------------------------------------");
		for(IntNode cursor = sortedNode; cursor != null; count++, cursor = cursor.getLink())
			System.out.println("Element in node " + count + ":  " + cursor.getData());

		System.out.println("\n");
	}
}