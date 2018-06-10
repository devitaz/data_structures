//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L2
// Class: CS260			     Lab #: 2
// Class time: 10:00am
// Date: 4/5/2014
// Program Name: Sequence.java
// Program Description: Driver Class-Tests methods from DoubleArraySortedSeq.java
//***************************************************************************
import java.util.*;

public class Sequence
{
	public static void main(String[] args)
	{
		Random gen = new Random();

		//	Testing both types of Constructors
		DoubleArraySortedSeq SeqOfNums1 = new DoubleArraySortedSeq();
		DoubleArraySortedSeq SeqOfNums2 = new DoubleArraySortedSeq();

		SeqOfNums1.DoubleArraySortedSeq(6);
		SeqOfNums2.DoubleArraySortedSeq();

		SeqOfNums1.addAll(SeqOfNums2);
		//	Testing add(), getCurrent(), size(), and start() methods
		System.out.println("\nNumbers in SeqOfNums1\n---------------------------------------");
		for(int i = 0; i < SeqOfNums1.getCapacity(); i++)
		{
			double num = gen.nextDouble()*25;
			SeqOfNums1.add(num);
		}
		SeqOfNums1.start();
		for(int i = 0; i < SeqOfNums1.size(); i++)
		{
			System.out.printf("%.2f\n",SeqOfNums1.getCurrent());
			SeqOfNums1.advance();
		}

		//	Testing getCapacity() method
		System.out.println("\nNumber of elements in SeqOfNums1 is: " + SeqOfNums1.getCapacity());
		SeqOfNums1.add(3.14);
		System.out.println("After adding 3.14 to SeqOfNums1, capacity is: " + SeqOfNums1.getCapacity());

		//	Testing trimToSize() and ensureCapacity() methods
		SeqOfNums1.trimToSize();
		System.out.println("After trimToSize(), capacity is: " + SeqOfNums1.getCapacity());
		SeqOfNums1.add(2.71);
		System.out.println("After adding 2.71 to SeqOfNums1, capacity is: " + SeqOfNums1.getCapacity());
		SeqOfNums1.ensureCapacity(22);
		System.out.println("After calling ensureCapacity(), capacity is: " + SeqOfNums1.getCapacity());

		System.out.println("\nNumbers in SeqOfNums1\n---------------------------------------");
		SeqOfNums1.start();
		for(int i = 0; i < SeqOfNums1.size(); i++)
		{
			System.out.printf("%.2f\n",SeqOfNums1.getCurrent());
			SeqOfNums1.advance();
		}

		//	Testing advance() and removeCurrent() methods
		SeqOfNums1.start();
		SeqOfNums1.advance();
		SeqOfNums1.advance();
		System.out.printf("\nThe current number in the SeqOfNums1 is: %.2f\n", SeqOfNums1.getCurrent());
		SeqOfNums1.removeCurrent();
		System.out.println("\nAfter calling removeCurrent(),");
		System.out.println("the numbers in SeqOfNums1 are\n---------------------------------------");
		SeqOfNums1.start();
		for(int i = 0; i < SeqOfNums1.size(); i++)
		{
			System.out.printf("%.2f\n",SeqOfNums1.getCurrent());
			SeqOfNums1.advance();
		}

		//	Testing clone() method
		DoubleArraySortedSeq theClone = (DoubleArraySortedSeq)SeqOfNums1.clone();
		System.out.println("\nAfter cloning SeqOfNums1,");
		System.out.println("the numbers in clone are\n---------------------------------------");
		theClone.start();
		for(int i = 0; i < theClone.size(); i++)
		{
			System.out.printf("%.2f\n",theClone.getCurrent());
			theClone.advance();
		}
		System.out.println("\nSeqOfNums1 != theClone returns: " + (SeqOfNums1 != theClone));
		System.out.println("SeqOfNums1.getClass() == theClone.getClass() returns: " + (SeqOfNums1.getClass() == theClone.getClass()));
		System.out.println("SeqOfNums1.equals(theClone) returns: " + (SeqOfNums1.equals(theClone)));

		//	Testing addAll() method
		SeqOfNums2.addAll(theClone);
		System.out.println("\nAfter addAll() copies the clone to SeqOfNums2,");
		System.out.println("the numbers in SeqOfNums2 are\n---------------------------------------");
		SeqOfNums2.start();
		for(int i = 0; i < SeqOfNums2.size(); i++)
		{
			System.out.printf("%.2f\n",SeqOfNums2.getCurrent());
			SeqOfNums2.advance();
		}

		//	Testing concat() method
		DoubleArraySortedSeq concatSeq = new DoubleArraySortedSeq();
		concatSeq = DoubleArraySortedSeq.concat(SeqOfNums1, SeqOfNums2);
		System.out.println("\nAfter concat() combines SeqOfNums1 and SeqOfNums2,");
		System.out.println("the numbers in concatSeq are\n---------------------------------------");
		concatSeq.start();
		for(int i = 0; i < concatSeq.size(); i++)
		{
			System.out.printf("%.2f\n",concatSeq.getCurrent());
			concatSeq.advance();
		}

		SeqOfNums1.add(22.22);
		System.out.println("\nAfter adding 22.22 to SeqOfNums1,");
		System.out.println("the numbers in SeqOfNums1 are\n---------------------------------------");
		SeqOfNums1.start();
		for(int i = 0; i < SeqOfNums1.size(); i++)
		{
			System.out.printf("%.2f\n",SeqOfNums1.getCurrent());
			SeqOfNums1.advance();
		}

		System.out.println("\nBut concatSeq remains the same without 22.22,");
		System.out.println("the numbers in concatSeq are\n---------------------------------------");
		concatSeq.start();
		for(int i = 0; i < concatSeq.size(); i++)
		{
			System.out.printf("%.2f\n",concatSeq.getCurrent());
			concatSeq.advance();
		}
		//	Testing search() method
		System.out.println("\nAfter searching SeqOfNums1 for 22.22, method returns: " + SeqOfNums1.search(22.22));
		System.out.println("\n\n");
	}
}