/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Debo
 */
public class LoginDAO {

    static Connection currentCon= null;
    //static ResultSet rs = null;

    public static LoginBean login(LoginBean bean) {
       try {
        
        String usname = bean.getUsername();
        String pword = bean.getPassword();
        System.out.println(usname + " and " + pword);
        currentCon = ConnectionManager.getConnection();
        //String searchQuery = "select * FROM login WHERE username='" + username + "' AND password='" + password + "'";
        String searchPre = "select * FROM login WHERE loginame = ? AND loginpass = ?";
        PreparedStatement pstmt = currentCon.prepareStatement(searchPre);

       
            //connecting to the DB
            pstmt.setString(1, usname);
            pstmt.setString(2, pword);
            
            
            //pstmt = currentCon.prepareStatement(searchPre);
          /*null exception coming from here*/  ResultSet rs = pstmt.executeQuery(searchPre);
            boolean userExists = rs.next();
            if (!userExists) {
                System.out.println("Username/Password entered is Incorrect or User does not Exists.");
                bean.setValid(false);
            } else if (userExists) {
                String userName = rs.getString(usname);

                System.out.println("Welcome " + usname);
                bean.setUserName(userName);

                bean.setValid(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, "Authenthication failed!", ex);
        }
        return bean;
    }
}
