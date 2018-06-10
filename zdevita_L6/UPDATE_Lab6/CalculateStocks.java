
	//			** Questions **
	//	-how do you want everything displayed? just capital gains/loss?

// uses Stocks class, LinkedQueue class, Node class

public class CalculateStocks
{
	private int element_count =0, current_stockprice =0, gain_loss =0;
	private int day =1, arraysize =0, total_shares =0;
	private int[] print_count; //makeshift pointer
	
	private Stocks[] stock;
	private PrintStocks[] printstocks;
	private LinkedQueue<Stocks> queue = new LinkedQueue<Stocks>();
	
	
//precondition:
//postcondition:
	public CalculateStocks(int days, PrintStocks[] printstocks, int[] print_count)
	{
		this.arraysize = days;
		this.printstocks = printstocks;
		this.print_count = print_count;
		this.stock = new Stocks[days];
	}
	
	
//precondition: stock array not full
//postcondition: new stock has been created and 
//					instance variables incremented
	//**
	//	-create new stock with passed in values
	//	
	//	-add stock to queue
	//
	//	-add info to printstocks so we can have a detailed 
	//		printout later
	//	
	//	-increment current_stockprice, count of elements,
	//		day, and increment total shares owned
	//**
	public void buyStocks(int shares, int price)
	{
		if((this.element_count <= this.arraysize))
		{
			this.stock[this.element_count] = new Stocks(shares, price, this.day); 
			this.queue.add(this.stock[this.element_count]);
			
			this.printstocks[print_count[0]] = new PrintStocks("Bought",shares,price,this.day,0);
			this.print_count[0]++; 
			
			this.current_stockprice = price; 
			this.total_shares += shares;
			
			this.element_count++;
			this.day++;
		}
	}
	
	
//precondition: stocks is not null
//postcondition: return true if we can sell, false if we couldn't
//					updates gain_loss, total_share variables
	//**
	//	-check if amount of shares being asked to sell is more
	//		then the amount of shares owned. Prevents null error
	//		also.
	//
	//	-check if queue is empty first
	//	
	//	-loop till you have sold enough stock so amount equals zero
	//	
	//	-if current stock has enough shares to sell
	//		subtract from amount, set the stock shares 
	//			minus the ones you sold
	//		if t_stock has no shares left, remove it from queue
	//		subtract shares sold from total_shares
	//	
	//	-else (share doesn't have enough to make amount = zero)
	//		subtract from amount 
	//		subtract shares sold from total_shares
	//		remove stock from queue cause all shares were sold from it
	//
	//	-add info to printstocks so we can have a detailed 
	//		printout later
	//
	//	-calls method in printstocks: calculateGainLoss passing in stock
	//		will update gain_loss variable with current gain/loss and 
	//		return value to be put into printstocks
	//
	//	-increment day (because we only buy/sell on one day)
	//**
	public boolean sellStocks(int amount)
	{
		Stocks t_stock;
		
		if(amount > this.total_shares) 
			return false;
		
		while((this.queue != null) && (amount > 0))
		{
			t_stock = this.queue.peek(); 
			int temp = amount; 
			
			if(t_stock.getShares() >= temp) 
			{			
				amount -= t_stock.getShares(); 
				t_stock.setShares(t_stock.getShares()-temp); 
				
				if(t_stock.getShares() == 0)
					this.queue.remove();
				
				this.total_shares -= temp; 
			}
			else 
			{
				amount -= t_stock.getShares();
				this.total_shares -= temp; 
				this.queue.remove();
			}
			this.printstocks[print_count[0]] = new PrintStocks("Sell",t_stock.getShares(),t_stock.getPrice(),this.day,this.calculateGainLoss(t_stock));
			this.print_count[0]++;
		}
		this.day++;
		return true;
	}
	
	
//precondition: stocks is not null	
//postcondition: increments gain_loss variable
	//**
	//	-store amount of shares stock has
	//	
	//	-check if temp has more then zero shares
	//		if zero shares make temp = 1 so no
	//		dividing by zero
	//
	//	-old: is cost of shares when bought
	// 	-current: is cost of shares at current price
	//
	//	-update gain_loss variable with current minus
	//		the old price giving gain or loss, then return
	// 		it aswell
	//**
	private int calculateGainLoss(Stocks t_stock)
	{
		int temp = t_stock.getShares(); 
		
		if(temp == 0) 
			temp =1;

		int old = (t_stock.getPrice() * temp);
		int current =(this.current_stockprice * temp); 

		this.gain_loss += (current - old);
		return (current - old);
	}
	
	
//precondition:
//postcondition:
	public int getGainLoss()
	{
		return this.gain_loss;
	}

		
//precondition:
//postcondition:
	public int getDaysElapsed()
	{
		return this.day;
	}
	
	/*
//precondition:
//postcondition:
	public void printStocks()
	{
		for(int i=0; i < this.element_count; i++)
		{
			System.out.println("::Share("+(i+1)+")::\nShares: "+
					this.stock[i].getShares()+"\nPrice: "+this.stock[i].getPrice()+
					"\nDay: "+this.stock[i].getDay()+" \n");
		}
	}
	*/
}
