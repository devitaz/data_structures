import java.util.Random;
import java.util.Scanner;

public class MenuStocks
{
	private final int MONTH;
	private int[] print_count;
	
	private CalculateStocks stocks;
	private PrintStocks[] printstocks;
	
	//***************************
	public MenuStocks(int MONTH, PrintStocks[] printstocks, int[] print_count, CalculateStocks stocks)
	{
		this.MONTH = MONTH;
		this.stocks = stocks;
		this.printstocks = printstocks;
		this.print_count = print_count;
	}
	
//precondition:
//postcondition:
	//***************************
	//		Start Menu
	//***************************
	public void startMenu()
	{
		String choice, goback;
		Scanner scan = new Scanner(System.in);

		// ** Ask first time **//
		this.displayStartMenu();
		System.out.print("\n>> Enter Choice: ");
		choice = scan.next();

		// ** 
		//	Loop until quit
		// **
		while((choice.toUpperCase().charAt(0)!='Q') )//&& (this.stocks.getDaysElapsed() <= this.MONTH))
		{
			goback = "clear";

			switch(choice)
			{
			//** Automatic **//
			case "1":
				this.randomStocks();
				this.printGainLoss();
				this.printDetailedStocks();
				choice = "Q"; //exit menu
			break;

			//** Manual **//
			case "2":
				this.mainMenu();
			break;	
			}

			// ** ask again ** //
			if(choice.charAt(0) != 'Q')
			{
				this.displayStartMenu();
				System.out.print("\n>> Enter Choice: ");
				choice = scan.next();
			}
		}
	}

//precondition:
//postcondition:
	//***************************
	//		Main Menu
	//***************************
	private void mainMenu()
	{
		String choice, goback;
		int share, price, sell;
		
		Scanner scan = new Scanner(System.in);
		
		// ** Ask first time **//
		this.displayMainMenu();
		System.out.print("\n>> Enter Choice: ");
		choice = scan.next();

		// ** 
		//	Loop until quit
		// **
		while((choice.toUpperCase().charAt(0)!='B') && (this.stocks.getDaysElapsed() <= this.MONTH))
		{
			goback = "clear";

			switch(choice)
			{
				//** Buy **//
				case "1": 
					while(goback.toUpperCase().charAt(0)!='B')
					{
						System.out.println("\nEnter Amount of Shares you want to buy:");
						
						Scanner scanNew = new Scanner(System.in);
						share = scanNew.nextInt();
	
						System.out.println("\nEnter Price you are buying them at:");
						//try
						{
							price = scanNew.nextInt();
							this.stocks.buyStocks(share, price);
						}
						//catch(InputMismatchException e)
						{
							//System.out.println("Error invaild input!(Looking for integer)");
						}
	
						System.out.print("\n>> (B)ack to Main Menu ");
						goback = scan.next();
					}
				break; 

				//** Sell **//
				case "2": 
					while(goback.toUpperCase().charAt(0)!='B')
					{
						System.out.println("\nEnter Amount of shares you want to sell:");
					
						Scanner scanNew = new Scanner(System.in);
						sell = scanNew.nextInt();
	
						if(this.stocks.sellStocks(sell))
							System.out.println("Successfully sold "+sell+" shares!");
						else
							System.out.println("Error! Trying to sell more shares then you own!");
	
						System.out.print("\n>> (B)ack to Main Menu ");
						goback = scan.next();
					}
				break; 

				//** Capital Gains/Loss **//
				case "3": 
					while(goback.toUpperCase().charAt(0)!='B')
					{
						System.out.println("\nCurrent Gains/Loss-\n= "+this.stocks.getGainLoss());
	
						System.out.print("\n>> (B)ack to Main Menu ");
						goback = scan.next();
					}
				break; 
			}

			// ** ask again ** //
			this.displayMainMenu();
			System.out.print("\n>> Enter Choice: ");
			choice = scan.next();
		}
	}

//precondition:
//postcondition:
	//***************************
	//		Company Menu
	//***************************
	private void companyMenu()
	{
		String choice, goback;
		Scanner scan = new Scanner(System.in);

		// ** Ask first time **//
		this.displayStartMenu();
		System.out.print("\n>> Enter Choice: ");
		choice = scan.next();

		// ** 
		//	Loop until quit
		// **
		while((choice.toUpperCase().charAt(0)!='Q') && (this.stocks.getDaysElapsed() <= this.MONTH))
		{
			goback = "clear";

			switch(choice)
			{
			//** Automatic **//
			case "1":
				while(goback.toUpperCase().charAt(0)!='B')
				{


					System.out.print("\n>> (B)ack to Main Menu ");
					goback = scan.next();
				}
				break;

				//** Manual **//
			case "2":
				while(goback.toUpperCase().charAt(0)!='B')
				{


					System.out.print("\n>> (B)ack to Main Menu ");
					goback = scan.next();
				}
				break;	
			}
		}
	}
	//***************************
	//***************************
	private void displayStartMenu()
	{
		System.out.println("\n::Menu Options::"+
				"\n****************\n"+
				"\n1. (Automatically) run stocks"+
				"\n2. (Manually) enter stocks"+
				"\n\n****************"+
				"\n Enter (Q) to quit");
	}
	
	//***************************
	private void displayMainMenu()
	{
		System.out.println("\n::Menu Options::"+
				"\n****************\n"+
				"\n1. (Buy) shares of stock"+
				"\n2. (Sell) shares of stock"+
				"\n3. (View) Capital Gains/Loss"+
				"\n\n****************"+
				"\n (B)ack to Main Menu");
	}

	//***************************
	private void displayCompanyMenu()
	{
		System.out.println("\n::Menu Options::"+
				"\n****************\n"+
				"\n1. IBM"+
				"\n2. APPLE"+
				"\n3. GOOGLE"+
				"\n4. MICROSOFT"+
				"\n5. TELSA MOTORS"+
				"\n\n****************"+
				"\n (B)ack to Main Menu");
	}
	
	
//precondition:
//postcondition:
	//***************************
	private void randomStocks()
	{
		Random r = new Random();
		int rand_shares, rand_price, rand_sell;
			
		while((this.stocks.getDaysElapsed() <= this.MONTH))
		{
			rand_shares = r.nextInt(50)+1; //buy shares in range
			rand_price = r.nextInt(20)+1; //price in range
			rand_sell = r.nextInt(10)+1; //sell in range
			
			if(stocks.getDaysElapsed()%3==0) // 1 in 3 chance
				this.stocks.sellStocks(rand_sell);
			else
				this.stocks.buyStocks(rand_shares,rand_price);
		}
	}
	
	
//precondition:
//postcondition:
	//***************************
	private void printGainLoss()
	{
		if(this.stocks.getGainLoss() > 0)
			System.out.println("\n\nYay! You had a gain this month!\nGains: "+
					this.stocks.getGainLoss()+"$");
		else
			System.out.println("\n\nSorry! You had a loss this month!\nLoss: "+
					this.stocks.getGainLoss()+"$");	
	}
	
	
//precondition:
//postcondition:
	//***************************
	private void printDetailedStocks()
	{
		for(int i =0; i < this.print_count[0]; i++)
		{
			if(i%5==0)
				System.out.println();

			if(printstocks[i].getBoughtSell().equals("Bought"))
				System.out.print("Day "+printstocks[i].getDay()+":"+
						" "+printstocks[i].getBoughtSell()+" -- "+
						"Shares: "+printstocks[i].getShare()+" "+
						"| Price: "+printstocks[i].getPrice()+"\n");

			if(printstocks[i].getBoughtSell().equals("Sell"))
				System.out.print("Day "+printstocks[i].getDay()+":"+
						" "+printstocks[i].getBoughtSell()+" -- "+
						"Shares: "+printstocks[i].getShare()+
						" | Price: "+printstocks[i].getPrice()+
						" | Gains/Loss: "+printstocks[i].getGainLoss()+"\n");
		}
	}
}
