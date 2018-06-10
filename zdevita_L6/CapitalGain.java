//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L5
// Class: CS260			     Lab #: 5
// Class time: 10:00am
// Date: 5/8/2014
// Program Name: CapitalGain.java
// Program Description:
//***************************************************************************
import java.util.*;

public class CapitalGain
{
	public static void main(String[] args)
	{
		final int OUT_OF = 20;
		final int DAYS = 30;
		final int MAX_PURCHASE = 80;

		final double MAX_VALUE = 150.00;

		int day = 0;
		int randomNum;

		Random random = new Random();

		//Stock Microsoft = new Stock();
		//Stock Amgen Inc = new Stock();
		//Stock AmTrust_Financial = new Stock();
		//Stock Emerge_Energy = new Stock();
		//Stock Tesla_Motors = new Stock();
		//Stock Google = new Stock();

		for(int i = 0; i < DAYS; i++)
		{
			//	How many shares to buy or sell
			randomNum = random.nextInt(MAX_PURCHASE);
			//	if... then Buy stocks. else... Sell stocks.
			if(random.nextInt(OUT_OF) > 7)
//				Microsoft.buy(randomNum);
			else
//				Microsoft.sell(randomNum);



		}


	}
}