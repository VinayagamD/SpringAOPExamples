package com.vinay.webcustomertracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		set up connection variable
		String user = "vinay";
		String password = "drago";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
//		get connection to the database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to the database : "+jdbcUrl);
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			out.println("SUCCESS!!!");
			con.close();
		}catch (Throwable e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
