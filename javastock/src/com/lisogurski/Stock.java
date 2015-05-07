package com.lisogurski;
import java.util.Date;
import java.util.Calendar;

public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private int recommendation;
	private int stockQuantity;
	
	final int BUY=0;
	final int SELL=1;
	final int REMOVE=2;
	final int HOLD=3;

	public Stock(String symbol, float ask, float bid, Date date){
		this.symbol=symbol;
		this.ask=ask;
		this.bid=bid;
	    this.date=date;
	
	}   
	
	public String getSymbol() {
        return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getAsk() {
		return ask;
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
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
	public int getRecommendation() {
		return this.recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}

	@SuppressWarnings("deprecation")
	public String getHtmlDescription(){
		
	return "<b>String symbol : </b>" +getSymbol()+ 
			                  "<b> Ask : </b>" +getAsk()+ 
			                  "<b> Bid : </b>" +getBid()+ 
			                  "<b> Date : </b>" +this.getDate().getMonth()+ 
			                  "/" + getDate().getDate() +
			                  "/" + (1900+getDate().getYear())+"<br>";

	}
	
	
}
