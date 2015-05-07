package com.lisogurski.app.service;

import java.util.Calendar;
import java.util.Date;

import com.lisogurski.Stock;
import com.lisogurski.model.Portfolio;

public class PortfolioManager {
	
	public Portfolio getPortfolio()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 11, 15);
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
		
		Portfolio portfolio = new Portfolio();
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);
		Stock stock2 = new Stock("ALL", (float)5.78, (float)5.5, date2);
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date3);
		
		portfolio.addPortfolioTitle("Portfolio 1");
		portfolio.addStock(stock1);
		portfolio.addStock(stock2);
		portfolio.addStock(stock3);
		
		return portfolio;		
	}

}
