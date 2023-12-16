package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet{
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<h1>Hello from MyServlet2</h1>");
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
				doPost(request, response);
		}
}
