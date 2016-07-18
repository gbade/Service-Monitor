/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Debo
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectTo = "login.jsp";
        try {
            System.out.println("In the Login Servlet");
            LoginBean user = new LoginBean();
            user.setUserName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user = LoginDAO.login(user);
            if (user.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                redirectTo = "index.jsp";
                JOptionPane.showMessageDialog(null, "Success logging in");
            } 
            //out.println("Error signing in.");
        } catch (Throwable exc) {
            System.out.println(exc);
        }
        response.sendRedirect(redirectTo);
    }
}
