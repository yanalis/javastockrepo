package com.lisogurski.model;


import com.myorg.javacourse.amitcohenapp321.Stock;

public class Portfolio {
	private String title;
	final int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	int portfolioSize;
	
	public void addStock(Stock stock)
	{
		stocks[portfolioSize] = stock;
		portfolioSize++;
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
	
	public void addPortfolioTitle(String titleToAdd)
	{
		this.title = titleToAdd;
	}
	
	public String getHtmlString()
	{
		String returnStr = "<h1>" + title + "</h1>";
		for (int i = 0; i < portfolioSize; i++)
		{
			returnStr = returnStr + stocks[i].getHtmlDescription();
		}
		return returnStr;
	}
	
}

