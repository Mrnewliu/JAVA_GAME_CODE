package com.hjc.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServer
 */
public class HttpServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget........");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println("param1 = " + param1);
		System.out.println("param2 = " + param2);
		response.getWriter().write("get method from server");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost......");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println("param1 = " + param1);
		System.out.println("param2 = " + param2);
		response.getWriter().write("post method from server");
		
	}

}
