package com.lisogurski;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JavastockServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		 int num1 ,num2 ,num3, num4 ;
	        num1 = 4;
	        num2 = 3;
	        num3 = 7;
	     int result1 = (num1+num2)*num3;  //(3+4)*7=49
	     int var1, result, var3;
	        var1 = (num3*num2)/num3+num2; //7*3(21)/7+3(10)=2
	        result = (num3*num1+num2)/num2;  // (7*4+3)/3=10
	        var3 = (num3+num2+num3+num2)/num1; //  (7+3+7+3)/4=5
	     String resultStr=new String("<h1>Result of"+var3+"*"+var1+"="+result+"</h1>");
	     resp.getWriter().println(resultStr);
     
	} 
       
}
