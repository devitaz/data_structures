//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L3
// Class: CS260			     Lab #: 3
// Class time: 10:00am
// Date: 4/14/2014
// Program Name: SortedLinkedList.java
// Program Description:
//***************************************************************************
import java.util.*;

public class IntNode //implements Cloneable
{
	private int data;
	private IntNode head, link;

	//head = new IntNode(29, null);

	public IntNode(int initialData, IntNode ininialLink)
	{
		data = initialData;
		link = initialLink;
	}

	public void addNodeAfter(int element)
	{
		link = new IntNode(element, link);
	}

	public void removeNodeAfter()
	{
		link = link.link;
	}

	public int getData()
	{


	}

	public IntNode getLink()
	{


	}

	public void setData(int newData)
	{
		data = newData;
	}

	public void setLink(IntNode newLink)
	{
		link = newLink;
	}




















}