/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

/**
 *
 * @author Debo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Calendar;


public class LogDB {

  static final String url = "jdbc:mysql://localhost:3306/monitor";
  


  public static void InsertDB(String service_source,String channel, String transaction_type,
          String provider_name, String pido_account, String beneficiary_id, String error_description, String error_date) 
  {
      try {

          String insert = "INSERT INTO error_log(service_source, channel, transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date)" +
                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");
 
          PreparedStatement ps = con.prepareStatement(insert);

          
          ps.setString(1, service_source);
          ps.setString(2, channel);
          ps.setString(3, transaction_type);
          ps.setString(4, provider_name);
          ps.setString(5, pido_account);
          ps.setString(6, beneficiary_id);
          ps.setString(7, error_description);
          ps.setString(8, error_date);
          ps.executeUpdate();
          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log(
                           Level.SEVERE, null, ex);
      }
  }

  /**public static LoginBean GetUserPass(LoginBean bean)
  {
     try{
       String usname = bean.getUsername();
       String pword = bean.getPassword();
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection(url, "root", "");
       String searchPre = "select * FROM login WHERE loginame = ? AND loginpass = ?";
       PreparedStatement ns = con.prepareStatement(searchPre);
       
       ns.setString(1, usname);
       ns.setString(2, pword);
       
       ResultSet rs = ns.executeQuery(searchPre);
       
      boolean userExists = rs.next();
      if (!userExists) {
           System.out.println("Username/Password entered is Incorrect or User does not Exists.");
           bean.setValid(false);
      } else if (userExists) {
           String userName = rs.getString(usname);

           System.out.println("Welcome " + usname);
           bean.setUserName(userName);

           bean.setValid(true);
     }} catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log(Level.SEVERE, null, "Authentication failed");
      }return bean;
  }**/
  public static List GetList() {

      List<String> list = new ArrayList<String>();

      try {

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");

          Statement stmt = con.createStatement();

          ResultSet result = stmt.executeQuery("SELECT * FROM error_log");

          while(result.next())
          {
             
             list.add(result.getString("id"));
             list.add(result.getString("service_source"));
             list.add(result.getString("channel"));
             list.add(result.getString("transaction_type"));
             list.add(result.getString("provider_name"));
             list.add(result.getString("pido_account"));
             list.add(result.getString("beneficiary_id"));
             list.add(result.getString("error_description"));
             list.add(result.getString("error_date"));
          } 

          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log( 
                           Level.SEVERE, null, ex);
      }
          return list;
  }
  
  public static List GetBill()
  {
    List<String> list = new ArrayList<String>();

      try {

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");

          Statement stmt = con.createStatement();

          ResultSet result = stmt.executeQuery("SELECT * FROM error_log WHERE service_source = 'Billbox' ");

          while(result.next())
          {
             
             list.add(result.getString("id"));
             list.add(result.getString("service_source"));
             list.add(result.getString("channel"));
             list.add(result.getString("transaction_type"));
             list.add(result.getString("provider_name"));
             list.add(result.getString("pido_account"));
             list.add(result.getString("beneficiary_id"));
             list.add(result.getString("error_description"));
             list.add(result.getString("error_date"));
          } 

          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log( 
                           Level.SEVERE, null, ex);
      }
          return list;
  }
  
  public static List GetService()
  {
    List<String> list = new ArrayList<String>();

      try {

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");

          Statement stmt = con.createStatement();

          ResultSet result = stmt.executeQuery("SELECT * FROM error_log WHERE service_source = 'Central Service' ");

          while(result.next())
          {
             
             list.add(result.getString("id"));
             list.add(result.getString("service_source"));
             list.add(result.getString("channel"));
             list.add(result.getString("transaction_type"));
             list.add(result.getString("provider_name"));
             list.add(result.getString("pido_account"));
             list.add(result.getString("beneficiary_id"));
             list.add(result.getString("error_description"));
             list.add(result.getString("error_date"));
          } 

          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log( 
                           Level.SEVERE, null, ex);
      }
          return list;
  }
  
  public static List GetNibss()
  {
    List<String> list = new ArrayList<String>();

      try {

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");

          Statement stmt = con.createStatement();

          ResultSet result = stmt.executeQuery("SELECT * FROM error_log WHERE service_source = 'NIBSS' ");

          while(result.next())
          {
             
             list.add(result.getString("id"));
             list.add(result.getString("service_source"));
             list.add(result.getString("channel"));
             list.add(result.getString("transaction_type"));
             list.add(result.getString("provider_name"));
             list.add(result.getString("pido_account"));
             list.add(result.getString("beneficiary_id"));
             list.add(result.getString("error_description"));
             list.add(result.getString("error_date"));
          } 

          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log( 
                           Level.SEVERE, null, ex);
      }
          return list;
  }

  public static void Delete(int id) {
      try {
          String delete = "DELETE from error_log WHERE id = ?";

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");
          PreparedStatement ps = con.prepareStatement(delete);

          ps.setInt(1, id);
          ps.executeUpdate();
          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log( 
             Level.SEVERE, null, ex);
      }
  }
}
