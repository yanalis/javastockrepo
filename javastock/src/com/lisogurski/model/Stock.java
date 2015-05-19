package com.lisogurski.model;
import java.util.Date;

public class Stock 
{	
    private String symbol;
    private float ask, bid;
    private Date date;
    //private ALGO_RECOMMENDATION recommendation;
    private int stockQuantity;
  

	public Stock(String symbol, float ask, float bid, Date date, int quantity) // New stock constructor
	{
	    this.symbol = symbol;
	    this.ask = ask;
	    this.bid = bid;
	    this.date = date;
	    this.stockQuantity = quantity;
	}
	
	public Stock(Stock stockToCopy) // Duplicate existing stock
	{
	    this.symbol = stockToCopy.getSymbol();
	    this.ask = stockToCopy.getAsk();
	    this.bid = stockToCopy.getBid();
	    this.date = stockToCopy.getDate();
	    //this.recommendation = stockToCopy.getRecommendation();
	    this.stockQuantity = stockToCopy.getStockQuantity();
	}

	// getters & setters //

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return this.ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}	
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/*public int getRecommendation() {
		return this.recommendation;
	}*/
	public int getStockQuantity()
	{
		return this.stockQuantity;
	}
	
	public void setStockQuantity(int quantityToSet) 
	{ 
		this.stockQuantity = quantityToSet;
	}
	
	@SuppressWarnings("deprecation")
	public String getHtmlDescription() // output stocks details
	{
	    return "<b>Symbol</b>: " + getSymbol() +
	    	   ", <b>Ask</b>: " + getAsk() +
	    	   ", <b>Bid</b>: " + getBid() +
		       ", <b>Date</b>: " + getDate().getMonth() +  "/" + getDate().getDate() + "/"  +(1900 + getDate().getYear())+
		       ", <b>Quantity</b>: " + getStockQuantity() + "<br>";
	}

}













