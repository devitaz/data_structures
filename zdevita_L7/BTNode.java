//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L4
// Class: CS260			     Lab #: 4
// Class time: 10:00am
// Date: 4/30/2014
// Program Name: BTNode.java
// Program Description:	Methods for generic Binary Tree Node
//***************************************************************************
import java.util.*;

@SuppressWarnings("unchecked")
public class BTNode<E>
{
	private E data;
	private BTNode<E> left, right;

/*
*	public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight)
Initialize a node with specified initial data and links to children.
Parameters:	initialData - the initial data of this new node
			initialLeft, initialRight - references to the children of this new node
Postcondition:	This new node contains the specified data and links to its children.
*/
	public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight)
	{
		data = initialData;
		left = initialLeft;
		right = initialRight;
	}
/*
*	public E getData()
This is an accessor method to obtain node's data.
*/
	public E getData()
	{
		return data;
	}
/*
*	public BTNode<E> getLeft()
This is an accessor method to obtain the node's reference to the left child.
*/
	public BTNode<E> getLeft()
	{
		return left;
	}

/*
*	public BTNode<E> getRight()
This is an accessor method to obtain the node's reference to the right child.
*/
	public BTNode<E> getRight()
	{
		return right;
	}
/*
*	public E getLeftMostData()
Accessor method to get the data from the leftmost node of the tree below this node.
Returns:	The data from the deepest node that can be reached from this node following left links
*/
	public E getLeftMostData()
	{
		if(left == null)
			return data;
		else
			return left.getLeftMostData();
	}
/*
*	public E getRightMostData()
Accessor method to get the data from the rightmost node of the tree below this node.
Returns:	The data from the deepest node that can be reached from this node following right links
*/
	public E getRightMostData()
	{
		if(right == null)
			return data;
		else
			return right.getRightMostData();
	}
/*
*	public void inorderPrint()
Use an in-order traversal to print the data from each node at or below this node of the binary tree.
Postcondition:	The data of this node and all its descendants have been printed using in-order traversal
*/
	public void inorderPrint()
	{
		if(left != null)
			left.inorderPrint();
		System.out.println(data);
		if(right != null)
			right.inorderPrint();
	}

/*
*	public void postorderPrint()
Use a post-order traversal to print the data from each node at or below this node of the binary tree.
Postcondition:	The data of this node and all its descendants have been printed using post-order traversal
*/
	public void postorderPrint()
	{
		if(left != null)
			left.postorderPrint();
		if(right != null)
			right.postorderPrint();
		System.out.println(data);
	}
/*
*	public void preorderPrint()
Use a pre-order traversal to print the data from each node at or below this node of the binary tree.
Postcondition:	The data of this node and all its descendants have been printed using pre-order traversal
*/
	public void preorderPrint()
	{
		System.out.println(data);
		if(left != null)
			left.preorderPrint();
		if(right != null)
			right.preorderPrint();
	}
/*
*	public boolean isLeaf()
Accessor method to determine whether a node is a leaf.
Returns:	true (if this node is a leaf), false otherwise
*/
	public boolean isLeaf()
	{
		return (left == null) && (right == null);
	}
/*
*	public void print(int depth)
Uses an in-order traversal to print the data from each node at or below this node of the binary tree.
Parameter:	depth - the depth of this node
Precondition:	depth is the depth of this node
Postcondition:	The data of this node and all its descendants have been printed using an in-order traversal
*/
	public void print(int depth)
	{
		int i;

		for(i = 1; i <= depth; i++)
			System.out.println("	");
		System.out.println(data);

		if(left != null)
			left.print(depth+1);
		else if(right != null)
		{
			for(i = 1; i <= depth+1; i++)
				System.out.println("	");
			System.out.println("--");
		}
		if(right != null)
			right.print(depth+1);
		else if(left != null)
		{
			for(i = 1; i <= depth+1; i++)
				System.out.println("	");
			System.out.println("--");
		}
	}
/*
*	public BTNode<E> removeLeftMost()
Remove the leftmost node of the tree with this node as its root.
Postcondition:	The tree starting at this node has had its leftmost node removed
*/
	public BTNode<E> removeLeftMost()
	{
		if(left == null)
			return right;
		else
		{
			left = left.removeLeftMost();
			return this;
		}
	}
/*
*	public BTNode<E> removeRightMost()
Remove the rightmost node of the tree with this node as its root.
Postcondition:	The tree starting at this node has had its rightmost node removed
*/
	public BTNode<E> removeRightMost()
	{
		if(right == null)
			return left;
		else
		{
			right = right.removeRightMost();
			return this;
		}
	}
/*
*	public void setData(E newData)
This is a modification method to set this node's data.
*/
	public void setData(E newData)
	{
		data = newData;
	}
/*
*	public void setLeft(BTNode<E> newLeft)
This is a modification method to set this node's reference to the left child.
*/
	public void setLeft(BTNode<E> newLeft)
	{
		left = newLeft;
	}
/*
*	public void setRight(BTNode<E> newRight)
This is a modification method to set this node's reference to the right child.
*/
	public void setRight(BTNode<E> newRight)
	{
		right = newRight;
	}
/*
*	public static <E> BTNode<E> treeCopy(BTNode<E> source)
Copy a binary tree.
Parameter:	source - a reference to the root node of a binary tree that will be copied
Returns:	The method has made a copy of the binary tree starting at source. The return
			value is a reference to the root of the copy.
*/
	public static <E> BTNode<E> treeCopy(BTNode<E> source)
	{
		BTNode<E> leftCopy, rightCopy;

		if(source == null)
			return null;
		else
		{
			leftCopy = treeCopy(source.left);
			rightCopy = treeCopy(source.right);
			return new BTNode<E>(source.data, leftCopy, rightCopy);
		}
	}
/*
*	public static <E> int treeSize(BTNode<E> root)
Compute the number of nodes in a binary tree.
Parameter:	root - the reference to the root of a binary tree
Returns:	the number of nodes in the tree with the given root
*/
	public static <E> int treeSize(BTNode<E> root)
	{
		if(root == null)
			return 0;
		else
			return 1 + treeSize(root.left) + treeSize(root.right);
	}
}