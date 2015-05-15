package com.lisogurski.stock.servlet;

import java.util.Date;

public class CopyStock 
{	
    private String symbol;
    private float ask, bid;
    private Date date;
    private int recommendation;
    private int stockQuantity;
    
    final int BUY = 0; 
    final int SELL = 1; 
    final int REMOVE = 2; 
    final int HOLD = 3; 

	public CopyStock(String symbol, float ask, float bid, Date date) // New stock constructor
	{
	    this.symbol = symbol;
	    this.ask = ask;
	    this.bid = bid;
	    this.date = date;
	}
	
	public CopyStock(CopyStock stockToCopy) 
	{
	    this.symbol=stockToCopy.getSymbol();
	    this.ask=stockToCopy.getAsk();
	    this.bid=stockToCopy.getBid();
	    this.date=stockToCopy.getDate();
	    this.recommendation=stockToCopy.getRecommendation();
	    this.stockQuantity=stockToCopy.getStockQuantity();
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol=symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask=ask;
	}
	public float getBid() {
		return bid;
	}	
	public void setBid(float bid) {
		this.bid=bid;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date=date;
	}
	public int getRecommendation() {
		return this.recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
		
	@SuppressWarnings("deprecation")
	public String getHtmlDescription() // output stocks details
	{
	    return "<b>Symbol</b>: " + getSymbol() +
	    	   ", <b>Ask</b>: " + getAsk() +
	    	   ", <b>Bid</b>: " + getBid() +
		       ", <b>Date</b>: " + getDate().getMonth() +  "/" + getDate().getDate() + "/"  +(1900 + getDate().getYear())+"<br>";
	}
}











