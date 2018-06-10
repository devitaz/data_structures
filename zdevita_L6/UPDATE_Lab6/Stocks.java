
public class Stocks
{
	private int shares =0, price =0, day =0;
	
	public Stocks(int shares, int price, int day)
	{
		this.shares = shares;
		this.price = price;
		this.day = day;
	}
	
	//**Accessors and Mutators
	//********************
	public int getShares()
	{
		return shares;
	}
	public void setShares(int shares)
	{
		this.shares = shares;
	}
	
	//********************
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}

	//********************
	public int getDay()
	{
		return day;
	}
	public void setCurrent_day(int day)
	{
		this.day = day;
	}
}
