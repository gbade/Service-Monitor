/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chinyere
 */
public class ConnectionManager {
    static Connection conn;
    public static Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String dbName ="monitor";
            String uname = "root";
            String pwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            try{
                conn = DriverManager.getConnection(url+dbName,uname,pwd);
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        catch(ClassNotFoundException e){
                System.out.println(e);
        }
        return conn;
    }

}
