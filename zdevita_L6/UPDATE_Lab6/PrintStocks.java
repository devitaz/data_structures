
public class PrintStocks
{
	private String boughtsell;
	private int shares, price, day, gainloss;
	
	public PrintStocks(String boughtsell, int shares, int price, int day, int gainloss)
	{
		this.boughtsell = boughtsell;
		this.shares = shares;
		this.price = price;
		this.day = day;
		this.gainloss = gainloss;
	}
	
	//**Accessors and Mutators
	//********************
	public String getBoughtSell()
	{
		return this.boughtsell;
	}
	
	//********************
	public int getShare()
	{
		return this.shares = shares;
	}
	
	//********************
	public int getPrice()
	{
		return this.price = price;
	}
	
	//********************
	public int getDay()
	{
		return this.day = day;
	}
	
	//********************
	public int getGainLoss()
	{
		return this.gainloss;
	}
}
