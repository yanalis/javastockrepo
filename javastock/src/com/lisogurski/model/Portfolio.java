
package com.lisogurski.model;

import java.util.Date;

public class Portfolio // A constructor for Portfolio class, building new portfolio instances
{
	private String title;
	final int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	int portfolioSize;
	
	public Portfolio(String title, Stock[] stocks, int portfolioSize) // New portfolio
	{
	    this.title = title;
	    this.stocks = stocks;
	    this.portfolioSize = portfolioSize;
	}	

	public Portfolio(Portfolio portfolioToCopy) // Copy portfolio
	{
		this.title = portfolioToCopy.getTitle();
		for (int i=0; i < portfolioToCopy.getPortfolioSize(); i++)
		{
			String symbol = portfolioToCopy.stocks[i].getSymbol();
			float ask = portfolioToCopy.stocks[i].getAsk();
			float bid = portfolioToCopy.stocks[i].getBid();
			Date date = portfolioToCopy.stocks[i].getDate();
			Stock stock = new Stock(symbol,ask,bid,date);
			this.stocks[i] = stock;
		}
		this.portfolioSize = portfolioToCopy.getPortfolioSize();
	}


	public void addStock(Stock stock) // Adding a stock to a portfolio
	{
		stocks[portfolioSize] = stock;
		portfolioSize++;
	}
	
	public void removeStock(String symbolToErase) // Removing a stock from a portfolio
	{
		if (stocks[portfolioSize-1].getSymbol().equals(symbolToErase)) // Stock to erase is the last stock
		{
			stocks[portfolioSize-1] = null;
			portfolioSize--;
		}
		else
		{
			for (int i=0; i < portfolioSize; i++) // Stock to erase is not the last stock
			{
				if (this.stocks[i].getSymbol().equals(symbolToErase))
				{
					this.stocks[i] = this.stocks[portfolioSize-1];
					this.stocks[portfolioSize-1] = null;
					portfolioSize--;
				}
			}
		}
	}
	
	public String getTitle()
	{
		return title; 	
	}
	
	public int getPortfolioSize()
	{
		return portfolioSize; 	
	}
	
	public Stock[] getStocks()
	{
		return stocks; 
	}
	
	public void setPortfolioTitle(String titleToSet)
	{
		this.title = titleToSet;
	}
	
	public String getHtmlString() // outputs all portfolio's details
	{
		String returnStr = "<h1>" + title + "</h1>";
		for (int i = 0; i < portfolioSize; i++)
		{
			returnStr = returnStr + stocks[i].getHtmlDescription();
		}
		return returnStr;
	}
	
}

