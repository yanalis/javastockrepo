package com.lisogurski;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.String;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
        
		Calendar calendar= Calendar.getInstance();
		calendar.set(2015,11,15);
		
		float ask1=(float)13.1;
		float bid1=(float)12.4;
		Date date1=calendar.getTime();
		Stock stock1=new Stock( " PIH ", ask1, bid1, date1);
		

		float ask2=(float)5.78; 
        float bid2=(float) 5.5; 
        Date date2=calendar.getTime(); 
        Stock stock2=new Stock( " ALL ", ask2, bid2, date2);
		
		
        float ask3=(float) 32.2;
        float bid3=(float) 31.5; 
        Date date3=calendar.getTime(); 
        Stock stock3=new Stock(" CAAS ", ask3, bid3, date3);
		
        resp.getWriter().println(stock1.getHtmlDescription());
        resp.getWriter().println(stock2.getHtmlDescription());
        resp.getWriter().println(stock3.getHtmlDescription());
	}
}
        
        