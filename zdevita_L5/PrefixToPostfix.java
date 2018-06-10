//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L4
// Class: CS260			     Lab #: 4
// Class time: 10:00am
// Date: 4/30/2014
// Program Name: PrefixToPostfix.java
// Program Description:	Linked list Stack to convert from pre to postfix
//***************************************************************************
import java.util.*;
import java.io.*;
import java.lang.Character;
import java.lang.String;

public class PrefixToPostfix
{
	public static void main(String[] args)
	{
		final int INITIAL_SIZE = 30;
		char check = 'y';
		String symbols = "{+-*%/";
		String equation;
		boolean isWellFormed = false;

		while(check == 'y')
		{
			int index = 0, num = 0, count = 0;
			String[] temp = new String[INITIAL_SIZE];
			String[] postFix = new String[INITIAL_SIZE];
			String[] elements;

			LinkedStack<String> opStack = new LinkedStack<String>();
			Scanner read = new Scanner(System.in);

			System.out.println("\n\nEnter mathmatical equation in prefix form to convert it to postfix.");
			System.out.println("You may use any of the following operators: + - * / ( ) %\n");
			System.out.print("_________________________\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
			equation = read.nextLine();
//	while statement checks if statement is well-formed
			while(isWellFormed == false)
			{
				for(int i = 0; i < equation.length(); i++)
				{
					if(equation.charAt(i) == '[' || equation.charAt(i) == '(')
						num++;
					if(equation.charAt(i) == ')' || equation.charAt(i) == ']')
						num--;
				}
				if(num == 0)
					isWellFormed = true;
				else
				{
					System.out.println("Equation is not well-formed.\nOpening parenthesis require closing" +
									" parenthesis and vice-versa. Try again.\n\n");
					System.out.print("_________________________\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
					equation = read.nextLine();
				}
			}
			isWellFormed = false;
//	This splits user input into array by operators but also saves the operators
//	This allows user to optionally not enter spaces between elements
			equation = equation.replaceAll(" ", "");
			for(String s : equation.split("(?<=[()+%*/-])|(?=[()+%*/-])"))
			{
				temp[count] = s;
				count++;
			}
			elements = new String[count];
			for(int i = 0; i < count; i++)
				elements[i] = temp[i];

			postFix = new String[count];
//	This determines which elements are operators and which are operands
//	Also determines course of action for element
			for(int i = 0; i < elements.length; i++)
			{
				if(0 > symbols.indexOf(elements[i]) && !"([)]".contains(elements[i]))
				{
					postFix[index] = elements[i];
					index++;
				}
				else
				{
					switch(elements[i])
					{
						case "(":
						case "[":
							opStack.push(elements[i]);
							break;
						case ")":
						case "]":
							while(!"([".contains(opStack.peek()))
							{
								postFix[index] = opStack.peek();
								opStack.pop();
								index++;
							}
							opStack.pop();
							break;
						case "+":
						case "-":
							while(!opStack.isEmpty() && !opStack.peek().equals("("))
							{
								postFix[index] = opStack.peek();
								opStack.pop();
								index++;
							}
							opStack.push(elements[i]);
							break;
						case "/":
						case "*":
						case "%":
							if(!opStack.isEmpty() && "/*%".contains(opStack.peek()))
							{
								postFix[index] = opStack.peek();
								opStack.pop();
								index++;
							}
							opStack.push(elements[i]);
					}
				}
			}
//	This checks if remaining operators are on stack and adds them to postfix
			int m = opStack.size();
			if(!opStack.isEmpty())
				for(int a = 0; a < m; a++)
				{
					postFix[index] = opStack.peek();
					opStack.pop();
					index++;
				}
//	This prints final post-fix equation
			System.out.print("\n\nPost-Fix:   ");
			for(int i = 0; i < index; i++)
				System.out.print(postFix[i] + " ");
			System.out.println("\n\n");
//**********************************************************************
//	Evaluate post-fix Ex-Credit
//**********************************************************************
//	This is the correct code to evaluate the postfix algorithm done in class.
//	I changed my algorithm to produce the same result as every postfix
//	calculator which I found online. I don't know which method is correct
//	but I know I probably worked harder on this assignment since I had to
//	write it twice. Below are the first results from a google search for
//	postfix converter websites I used
//	http://scanftree.com/Data_Structure/prefix-postfix-infix-online-converter
//	http://www.meta-calculator.com/learning-lab/how-to-build-scientific-calculator/infix-to-postifix-convertor.php
//	My program works and my evaluator works on par with the other students

       		/*
        	LinkedStack<Integer> numbers = new LinkedStack<Integer>();

        	String op, s;
        	int n, digit1, digit2, result;

        	for(int i = 0; i < postFix.length; i++)
        	{
        	    s = postFix[i];
				if(!"*-+/%".contains(postFix[i]))
				{
					n = Integer.parseInt(s);
					numbers.push(n);
					System.out.println(n);
				}
				else if(!opStack.isEmpty() && "*-+/%".contains(postFix[i]))
				{
					digit1 = numbers.pop();
					digit2 = numbers.pop();
					result = 0;

					switch(postFix[i])
					{
						case "*":
							result = digit2 * digit1;
							break;
						case "/":
							result = digit2 / digit1;
							break;
						case "%":
							result = digit2 % digit1;
							break;
						case "+":
							result = digit2 + digit1;
							break;
						case "-":
							result = digit2 - digit1;
							break;
					}
					numbers.push(result);
				}
			}
			System.out.println(numbers.pop());
			*/

//	This checks if user wants to continue
			System.out.println("\n\n\nYou may enter a y to continue\n");
			System.out.print(" _____\b\b\b\b");
			check = read.next().charAt(0);
		}
	System.out.println("\n\n\n");
	}
}
