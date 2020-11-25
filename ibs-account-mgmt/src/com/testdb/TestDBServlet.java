package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//set connection variables
		String user = "IBSBANK";
		String password = "password";
		String jdbcurl = "jdbc:mysql://localhost:3306/ibs_account_management?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection to db
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database:" + jdbcurl);
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcurl, user, password);
			out.println("Connection Successfull !!! ");
		}
		
		catch(Exception ex){
			ex.printStackTrace();
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
