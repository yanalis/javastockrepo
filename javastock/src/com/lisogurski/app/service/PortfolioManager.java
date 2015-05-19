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

      cal.set(2015, 11, 15); 

      Date date1 = cal.getTime(); 

      Date date2 = cal.getTime(); 

      Date date3 = cal.getTime(); 

      String portfolioTitle = "Portfolio 1"; 

      Stock st1 = new Stock("PIH", (float)13.1, (float)12.4, date1); 

      Stock st2 = new Stock("ALL", (float)5.78, (float)5.5, date2); 

      Stock st3 = new Stock("CAAS", (float)32.2, (float)31.5, date3); 

      Stock[] stockArr = {st1,st2,st3}; 

      int stocksAmount = 3; 

      Portfolio portfolio = new Portfolio(portfolioTitle, stockArr, stocksAmount); 

/*Stock st1 = new Stock("PIH", (float)13.1, (float)12.4, date1); 

Stock st2 = new Stock("ALL", (float)5.78, (float)5.5, date2); 

Stock st3 = new Stock("CAAS", (float)32.2, (float)31.5, date3);*/ 

// portfolio.setPortfolioTitle("Portfolio 1"); 

/*portfolio.addStock(st1); 

portfolio.addStock(st2); 

portfolio.addStock(st3);*/ 

      return portfolio; 

      }

}











