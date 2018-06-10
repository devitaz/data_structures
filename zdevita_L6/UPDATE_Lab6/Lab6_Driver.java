
public class Lab6_Driver
{	
	private final int MONTH = 30;	
	private int[] print_count = {0}; // makeshift pointer
	
	private CalculateStocks stocks;
	private MenuStocks menu;
	private PrintStocks[] printstocks = new PrintStocks[MONTH+4]; //+4 is buffer
	
	//**
	//	-create new CalculateStocks class, takes in
	//		month, printstocks, print_count as instance
	//		variables. This class contains most of the logic
	//	
	//	-create a new Menu class that contains methods to
	//		loop menu. takes in days to run, printstocks,
	//		print_count, and the stocks to be used
	//
	//	-startMenu() method starts the menu loop
	//**
	public Lab6_Driver()
	{
		stocks = new CalculateStocks(MONTH, printstocks, print_count); 
		menu = new MenuStocks(MONTH, printstocks, print_count, stocks); 
		
		menu.startMenu();
	}
	public static void main(String[] args)
	{
		new Lab6_Driver();
	}
}
