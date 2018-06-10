//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L5
// Class: CS260			     Lab #: 5
// Class time: 10:00am
// Date: 5/8/2014
// Program Name: Stock.java
// Program Description:
//***************************************************************************
import java.util.*;

public class Stock
{
	final int OUT_OF = 20;
	private final double MAX_VALUE = 150.00;
	private int dayNumber, Shares = 100;
	private double total$, price;
	private double value = 80;

	private LinkedQueue<Object> Assets = new LinkedQueue<Object>();
	private Random gen = new Random();


	public Stock(int numOfShares, double cost)
	{
		//Assets = new LinkedQueue<Object>();
		Shares = numOfShares;
		price = cost;
	}

	public void buy(int numOfShares, double cost)
	{
		Shares = numOfShares;
		price = cost;

		//Assets.add
	}

	public void sell()
	{


	}

	public void gainOrLoss()
	{
		double change = gen.nextDouble()*8;

		//	if... then Stock value increases. else... Stock value decreases
		if(gen.nextInt(OUT_OF) < 14)
			setValue(value += change);
		//	Stock value decreases
		else
			setValue(value -= change);

		if(value >= MAX_VALUE)
			split();

		//	Value will never be negative
		if(value <= .05)
			setValue(value = .05);
	}

	private void split()
	{
		setValue(value /= 2);
		setShares(Shares *= 2);
		System.out.println("Congratulations, you had a stock split.");
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double newValue)
	{
		value = newValue;
	}

	public int getShares()
	{
		return Shares;
	}

	public void setShares(int newShares)
	{
		Shares = newShares;
	}



}