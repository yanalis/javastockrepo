package com.lisogurski.model;

import java.util.Date;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

public class Portfolio implements PortfolioInterface // A constructor for Portfolio class, building new portfolio instances
{
	
	public enum ALGO_RECOMMENDATION{
		
		BUY, SELL, REMOVE, HOLD;
	}
	
	// members
	final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private StockInterface[] stocks;
	private int portfolioSize = 0;
	private float balance = 0;
	
	// ctors
	public Portfolio() // New portfolio
	{
	    this.title = new String("uninitialized portfolio");
	    this.stocks = new Stock[MAX_PORTFOLIO_SIZE]; 
	    this.portfolioSize = 0;
	    this.balance = 0;
	}	
	
	public Portfolio(StockInterface[] stockarr) // New portfolio receiving stock array
	{
	    //this.title = "uninitialized portfolio";
		this.title = new String("uninitialized portfolio");
	    this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE]; 
	    this.portfolioSize = stockarr.length;
	    for (int i=0; i< this.portfolioSize; i++){
	    	this.stocks[i] = new Stock ((Stock) stockarr[i]);
	    }
	    //this.portfolioSize = 0;
	    this.balance = 0;
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
			int quantity = ((Stock) portfolioToCopy.stocks[i]).getStockQuantity(); // CASTED
			Stock stock = new Stock(symbol,ask,bid,date,quantity);
			this.stocks[i] = stock;
		}
		this.portfolioSize = portfolioToCopy.getPortfolioSize();
	}
	
	
	// methods
	
	
	/*public void addStock(Stock stock) 
	{		
		boolean exist = false;

		if (portfolioSize == MAX_PORTFOLIO_SIZE) {
			System.out.println("Can’t add new stock, portfolio can have only"
					+ portfolioSize + "stocks");
		}

		for (int i=0; i < portfolioSize;) {

			if (stocks[i].getSymbol() == stock.getSymbol())
			{
				exist = true;
				i = portfolioSize;
			}
			else{
				i++;
			}
		}

		if(exist==false){
			this.stocks[portfolioSize] = stock;
			stock.setStockQuantity(0);
			portfolioSize++;
		}
	}*/

	//////////////////////////////start of addStock//////////////////////////////////////
	
	public void addStock(Stock stock) // Adding a stock to a portfolio
	{
		boolean stockExists = false;
		String answerStr = "";
		
		if (this.getPortfolioSize() == MAX_PORTFOLIO_SIZE) // case portfolio is FULL
		{
			answerStr = "Portfolio is full, can not add stock";
			System.out.println(answerStr);
			return;
		}
			
		for (int i=0; i < portfolioSize; i++) // case stock EXISTS
		{
			if (this.stocks[i].getSymbol().equals(stock.getSymbol()))
			{
				stockExists = true;
				answerStr = "Stock already exists";
				System.out.println(answerStr);
				return;
			}
		}

		if (stockExists == false) 
		{
			this.stocks[portfolioSize] = stock; // PROBABLY SOME ERROR WITH NULL HERE.
			portfolioSize++;
			answerStr = "Stock added";
			System.out.println(answerStr);	
		}
	}
	
	//////////////////////////////end of addStock//////////////////////////////////////
	
	public boolean removeStock(String symbolToErase) // Removing a stock from a portfolio
	{
		boolean stockRemoved = false;
		boolean stockSold;
		
		if (stocks[portfolioSize-1].getSymbol().equals(symbolToErase)) // Stock to erase is the last stock
		{
			stockSold = sellStock(stocks[portfolioSize-1].getSymbol(), ((Stock) stocks[portfolioSize-1]).getStockQuantity()); // CASTED
			if (stockSold == true) // selling process succeed - removing stock
			{
				stocks[portfolioSize-1] = null;
				portfolioSize--;
				stockRemoved = true;
			}
			else
			{
				stockRemoved = false; // selling process didn't succeed -> removing process can't succeed
			}
		}
		else // stock to erase is not the last stock
		{
			for (int i=0; i < portfolioSize; i++)
			{
				if (this.stocks[i].getSymbol().equals(symbolToErase))
				{
					stockSold = sellStock(stocks[i].getSymbol(), ((Stock) stocks[i]).getStockQuantity());
					if (stockSold == true) // selling stock process succeed - removing stock
					{
						this.stocks[i] = this.stocks[portfolioSize-1];
						this.stocks[portfolioSize-1] = null;
						portfolioSize--;
						stockRemoved = true;
					}
				}
			}
		}
		return stockRemoved;
	}
	
	public boolean sellStock(String stockToSell, int quantity) // Sell a stock
	{
		boolean sellSucceed = false;
		boolean stockFound = false;

		for (int i=0; i < this.portfolioSize && stockFound == false; i++) // running through all stocks in portfolio
		{	
			if (stockToSell.equals(stocks[i].getSymbol())) // finding the stock in the portfolio
			{
				stockFound = true;
				
				if (quantity == -1) // sell all stock's quantity
				{
					updateBalance((float)quantity * stocks[i].getBid());
					((Stock) stocks[i]).setStockQuantity(((Stock) stocks[i]).getStockQuantity()-quantity);
					sellSucceed = true;
				}
				else if (quantity > ((Stock)stocks[i]).getStockQuantity()) 
				{
					System.out.println("Not enough stocks to sell");	
					return sellSucceed; // FALSE, means sell didn't succeed 
				}
				else // case ok
				{
					updateBalance((float)quantity * stocks[i].getBid());
					((Stock) stocks[i]).setStockQuantity(((Stock) stocks[i]).getStockQuantity()-quantity);
					sellSucceed = true;
				}
			}
		}
		return sellSucceed; 
	}
	
	public boolean buyStock(Stock stockToPurchase, int quantity) // Buy a stock
	{
		boolean stockIsInPortfolio = false;
		boolean buySucceed = false;

		for (int i=0; i < portfolioSize; i++) // run through all of the portfolio
		{
			if (stocks[i].getSymbol().equals(stockToPurchase.getSymbol())) // stock to purchase is already in the portfolio
			{
				stockIsInPortfolio = true;
				
				if (quantity == -1) // case -1 -> purchasing until we're out of money
				{
					while (balance > stockToPurchase.getAsk())
					{			
						quantity--;
						((Stock) stocks[i]).setStockQuantity(((Stock) stocks[i]).getStockQuantity()+1); // CASTED
						this.balance = this.balance - stockToPurchase.getAsk();
					}
					buySucceed = true;
				}
				else if ((stockToPurchase.getAsk() * quantity) > this.balance) // case not enough funds
				{			
						System.out.print("Not enough balance to complete purchase");					
				}
				else // case enough funds
				{
					((Stock) stocks[i]).setStockQuantity(((Stock) stocks[i]).getStockQuantity()+quantity); // CASTED
					this.balance -= stockToPurchase.getAsk() * quantity;	
					buySucceed = true;
				}
			}
		}		
		if (stockIsInPortfolio == false) // stock to purchase is NOT inside portfolio
		{
			if (portfolioSize == MAX_PORTFOLIO_SIZE) // no space for the stock
			{
				System.out.print("Portfolio is full, purchase did not complete");				
			}
			else if (this.balance > stockToPurchase.getAsk() * quantity) // there is space, there are funds
			{
				stockToPurchase.setStockQuantity(quantity); 
				this.balance -= (stockToPurchase.getAsk() * quantity);
				addStock(stockToPurchase);
				buySucceed = true;	
			}
			else // there is space, there are no funds
			{
				System.out.print("Not enough balance to complete purchase");					
				buySucceed = false;	
			}
		}
	return buySucceed;
	}
	
	
	// getters & setters //
	public String getTitle()
	{
		return title; 	
	}
	
	public void setTitle(String titleToSet)
	{
		this.title = titleToSet;	
	}
	
	public int getPortfolioSize()
	{
		return portfolioSize; 	
	}
	
	public StockInterface[] getStocks()
	{
		return stocks; 
	}
	
	public void setPortfolioTitle(String titleToSet)
	{
		this.title = titleToSet;
	}
	
	public void updateBalance(float amount)
	{
		if ((this.balance + amount) < 0)
		{
			this.balance = 0;
		}
		else
		{
			this.balance += amount;
		}
	}
	
	public double getStocksValue()
	{
		double totalVal = 0;
		for (int i=0; i < portfolioSize; i++)
		{
			totalVal = totalVal + (((Stock) this.stocks[i]).getStockQuantity() * this.stocks[i].getBid());
		}
		return totalVal;
	}
	
	public double getTotalValue()
	{
		return this.getStocksValue()+getBalance();
	}
	
	public float getBalance()
	{
		return this.balance;
	}
	
	public void setBalance(double balanceToSet)
	{
		this.balance = (float)balanceToSet;
	}
	
	public int findStock (String stockToFind)
	{
		for(int i = 0; i< this.portfolioSize; i++)
		{
			if(stockToFind.equals(this.stocks[i].getSymbol()))
			{
				return i;
			}
		}
		return -1;
	}
	
	public StockInterface findStockPlace (String stockToFind)
	{
		int i = 0;
		for( i = 0; i< this.portfolioSize; i++)
		{
			if(stockToFind.equals(this.stocks[i].getSymbol()))
			{
				return this.stocks[i];
			}
		}
		return null;
	}


	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	public String getHtmlString() // outputs all portfolio's details
	{
		String returnStr = "<h1>" + title + "</h1>";
		for (int i = 0; i < portfolioSize; i++)
		{
			returnStr = returnStr + ((Stock) stocks[i]).getHtmlDescription() + "<br>"; // CASTED
		}
		returnStr = returnStr + "<br>" + "Total Portfolio Value: " + getTotalValue() + "<br>"
							  + "Total Stocks Value: " + this.getStocksValue() + "<br>"
				           	  + "Balance: " + getBalance();
		return returnStr;
	}
}