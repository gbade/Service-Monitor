/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Debo
 */
public class TestA{
    static final String url = "jdbc:mysql://localhost:3306/monitor";
   
    
    
    
    public List getErrDesc(){
            //String data = null;
            Date date = null;
            DateFormat format;
            List list = new ArrayList();
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root", "");

                Statement stmt = con.createStatement();

                ResultSet result = stmt.executeQuery("SELECT error_description, error_date FROM error_log WHERE service_source = 'Billbox' ");
    
                while (result.next()) {  //retrieve data
                    
                    String ds = result.getString("error_date");
                    format = new SimpleDateFormat("M/d/yyyy H:m:s a");
                    date = (Date)format.parse(ds);
                    
                    ErrObj es = new ErrObj(result.getString("error_description"), date);
                    list.add(es);
                }
                con.close();

            } catch (Exception ex) {
                Logger.getLogger(LogDB.class.getName()).log( 
                                Level.SEVERE, null, ex);
            }
            return list;
      }
    
    public List getErrDS(){
            String ds = null;
            List<Object> sd = new ArrayList<Object>();
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root", "");

                Statement stmt = con.createStatement();

                ResultSet result = stmt.executeQuery("SELECT error_description FROM error_log WHERE service_source = 'Billbox' ");
    
                while (result.next()) {  //retrieve data
                    
                    ds = result.getString("error_description");
                    
                    sd.add(ds);
                }
                con.close();

            } catch (Exception ex) {
                Logger.getLogger(LogDB.class.getName()).log( 
                                Level.SEVERE, null, ex);
            }
            return sd;
    }
    
    public String getErr(){
      String test = "This is just an error test";
      return test;
    }
    
    public Date getTimeStamp(){
      Calendar calendar = Calendar.getInstance();
      Date stamp = calendar.getTime();
      SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d h:m:s a z");
      dateFormatter.format(stamp);
      return stamp;
    }
    
    public List <Date> getTime(){
        Date date = null;
        DateFormat format;
        List<Date> dates = new ArrayList<Date>();
        //String ds = null;
        try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root", "");

                Statement stmt = con.createStatement();

                ResultSet result = stmt.executeQuery("SELECT * FROM error_log WHERE service_source = 'Billbox' ");
                
                while (result.next()) {  //retrieve data
                    String ds = result.getString("error_date");
                    format = new SimpleDateFormat("M/d/yyyy H:m:s a");
                    //System.out.println(ds);
                    date = (Date)format.parse(ds); 
                    dates.add(date);

                }
                con.close();

            } catch (Exception ex) {
                Logger.getLogger(LogDB.class.getName()).log( 
                                Level.SEVERE, null, ex);
            }
        return dates;
    }
    
    
}
