/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

/**
 *
 * @author Debo
 */
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginAuthentication extends HttpServlet{

	private ServletConfig config;
	
	public void init(ServletConfig config)
	  throws ServletException{
		 this.config=config;
	   }
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
		PrintWriter out = response.getWriter();
		String connectionURL = "jdbc:mysql://localhost:3306/monitor";
		Connection connection=null;
		ResultSet rs;
		String userName=new String("");
		String passwrd=new String("");
		response.setContentType("text/html");
                //String redirectTo="login.jsp";
		try {
			 // Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", ""); 
			//Add the data into the database
			String sql = "select * from login";
			Statement s = connection.createStatement();
			s.executeQuery (sql);
			rs = s.getResultSet();
			while (rs.next ()){
				userName=rs.getString("loginame");
				passwrd=rs.getString("loginpass");
			}
			rs.close ();
			s.close ();
			}catch(Exception e){
			System.out.println("Exception is ;"+e);
			}
			if(userName.equals(request.getParameter("username")) && passwrd.equals(request.getParameter("password"))){
				out.println("WELCOME "+ userName);
                                HttpSession session = request.getSession(true);
                                session.setAttribute("currentSessionUser", userName);
                                response.sendRedirect("central.jsp");
                                
			}
			else{
				response.sendRedirect("login.jsp");
                                out.println("Please enter correct username and password");
				out.println("<b>Login again</b>");
			}
	}
}	
