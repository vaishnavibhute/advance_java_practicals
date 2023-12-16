package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			response.setHeader("Refresh", "1");
			PrintWriter writer=response.getWriter();
			Date date=new Date();
			writer.println("<h2>" +date+ "</h2>");
		}
}
