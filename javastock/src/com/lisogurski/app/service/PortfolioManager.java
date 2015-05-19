package com.lisogurski.app.service;

import java.util.Calendar;
import java.util.Date;

import com.lisogurski.model.Portfolio;
import com.lisogurski.model.Stock;

public class PortfolioManager 
{	
	public Portfolio getPortfolio()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 12, 15);
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
		
		Portfolio portfolio = new Portfolio();

		portfolio.setPortfolioTitle("Exercise 7 portfolio");
		portfolio.setBalance(10000);
		
		Stock st1 = new Stock("PIH", (float)10.0, (float)8.5, date1, 0);
		Stock st2 = new Stock("AAL", (float)30.0, (float)25.5, date2, 0);
		Stock st3 = new Stock("CAAS", (float)20.0, (float)15.5, date3, 0);
		
		portfolio.buyStock(st1, 20);
		portfolio.buyStock(st2, 30);		
		portfolio.buyStock(st3, 40);
		portfolio.sellStock("AAL", 30);  
		portfolio.removeStock("CAAS");
		
		////////////////////NOT RELEVANT//////////////////
		// portfolio.setPortfolioTitle("Portfolio 1");
		/*portfolio.addStock(st1);
		portfolio.addStock(st2);
		portfolio.addStock(st3);*/
		////////////////////NOT RELEVANT//////////////////

		return portfolio;		
	}
}



