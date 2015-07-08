package com.lisogurski.model;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;

public class Stock implements StockInterface
{	
	
	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD
	}
	
	// members
    private ALGO_RECOMMENDATION recommendation;
    private String symbol;
    private float ask, bid;
    private Date date;
    private int stockQuantity;
    transient private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  
    // ctors
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
	    this.recommendation = stockToCopy.getRecommendation();
	    this.stockQuantity = stockToCopy.getStockQuantity();
	}
	
	public Stock() 
	{
		this.symbol = new String();
		this.ask = 0;
		this.bid = 0;
		this.date = new Date();
		this.recommendation = ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity = 0;
	}
	
	// methods
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
	
	public int getStockQuantity()
	{
		return this.stockQuantity;
	}
	
	public void setStockQuantity(int quantityToSet) 
	{ 
		this.stockQuantity = quantityToSet;
	}
	

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	@SuppressWarnings("deprecation")
/*	public String getHtmlDescription() // output stocks details
	{
	    return "<b>Symbol</b>: " + getSymbol() +
	    	   ", <b>Ask</b>: " + getAsk() +
	    	   ", <b>Bid</b>: " + getBid() +
		       ", <b>Date</b>: " + getDate().getMonth() +  "/" + getDate().getDate() + "/"  +(1900 + getDate().getYear())+
		       ", <b>Quantity</b>: " + getStockQuantity() + "<br>";
	}*/
	
	public String getHtmlDescription() {
				String resultStr = "<b>Stocksymbol</b>: "
				+this.getSymbol()+  "<b> Bid</b>: "
				+this.getBid()+ "<b> Ask</b>: "
				+this.getAsk()+ "<b> Quantity</b>: "
				+ this.getStockQuantity() + "<b> Date:</b> "
				+ this.dateFormat.format(this.getDate());
				return resultStr;
	}
}

