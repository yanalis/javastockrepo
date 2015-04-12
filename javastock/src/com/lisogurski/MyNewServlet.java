package com.lisogurski;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setContentType("text/html");
        
		
		//part 1
		int radius=50;
		double pi=Math.PI;
		double area=radius*radius*pi;
		String line1 = new String("Calculation 1: Area of circle with radius"+radius+"is:" +area+ "squere cm.");
        
		
		//part 2
		double angleB=30;
		double hypotenuse=50;
		double radians=Math.toRadians(angleB);
		double opposite=radians*hypotenuse;
		String line2 = new String("Calculation 2: Length of opposite where angle B is" +angleB+ "and hypotenuse is" +hypotenuse+ ", is: " +opposite+ "cm.");

		
		
		//part 3
		int base=20, exp=13;
		double value;
		value = Math.pow(base, exp);
		String line3 = new String("Calculation 3: Power of " +base+ " with exp of " +exp+ " is : "+value);
		
		
		// define a string to include all calculations:
		String resultStr = line1 + "<br>" + line2 + "<br>" +line3;
		
		// add this string inside the response print line:
		resp.getWriter().println(resultStr);
	}
}
