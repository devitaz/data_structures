//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L7
// Class: CS260			     Lab #: 7
// Class time: 10:00am
// Date: 5/15/2014
// Program Name: BinarySearchTree.java
// Program Description:	Driver class for creating a balanced Binary Search Tree
//***************************************************************************
import java.util.*;

public class BinarySearchTree
{
	public static void main(String[] args)
	{
		//	A sorted array
		int[] sortedArray = {2, 5, 6, 10, 11, 13, 17, 18, 20, 25, 27, 28, 29, 30, 33};

		BTNode<Integer> myTree = arrayToTree(sortedArray);

		//	Testing treeSize() method
		System.out.println("The tree size is: " + BTNode.treeSize(myTree) + "\n");

		//	Testing inorderPrint() method
		System.out.println("::::Tree in in-order::::");
		System.out.println("--------------------------");
		myTree.inorderPrint();

		//	Testing postorderPrint() method
		System.out.println("\n\n::::Tree in post-order::::");
		System.out.println("--------------------------");
		myTree.postorderPrint();

		System.out.println("\n\n\n");
	}
	/*
	*	private static BTNode<Integer> arrayToTree(int[] anArray)
	Method that converts a sorted array to a Binary Tree Node.
	Parameter:	anArray - a sorted array of integers
	Precondition:	Array must be in sorted order
	Returns:	Method creates binary tree and returns the reference to the root
	*/
	private static BTNode<Integer> arrayToTree(int[] anArray)
	{
		int root = (anArray.length)/2;
		int[] left = new int[root];
		int[] right = new int[anArray.length-(root+1)];

		BTNode<Integer> result = new BTNode<Integer>(anArray[root], null, null);

		if(left.length > 0)
		{
			for(int i = 0; i < root; i++)
				left[i] = anArray[i];
			result.setLeft(arrayToTree(left));
		}
		if(right.length > 0)
		{
			for(int i = 0; i < anArray.length-(root+1); i++)
				right[i] = anArray[(root+1)+i];
			result.setRight(arrayToTree(right));
		}
		return result;
	}
	//***************************************************************************
	//	Quicksort was not actually implemented and was not part of assignment
	//***************************************************************************
	private void quickSort(int[] unsortedArray, int first, int n)
	{
		int pivotIndex;
		int n1, n2;

		if(n > 1)
		{
			pivotIndex = partition(unsortedArray, first, n);
			n1 = pivotIndex - first;
			n2 = n - n1 - 1;

			quickSort(unsortedArray, first, n1);
			quickSort(unsortedArray, pivotIndex + 1, n2);
		}
	}
	private static int partition(int[] theArray, int first, int n)
	{
		int arr = theArray[first];
		int x = first - 1;
		int y = n + 1;

		while(true)
		{
			x++;
			while(x < y && theArray[x] < arr)
				x++;
			y--;
			while(y > first && theArray[y] > arr)
				y--;
			if(x < y)
				swap(theArray, x, y);
			else
				return y;
		}
	}
	private static void swap(int[] arr, int x, int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}