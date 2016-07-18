/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.TimerTask;
import java.util.Timer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
/**
 *
 * @author Chinyere
 */
public class JaxbTester3 {
    
    public JaxbTester3(){
    }
    
    public void XMLParser()throws JAXBException, IOException, SQLException{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitor", "root", "");
                Statement ns=con.createStatement(); 
                Statement duplicate = con.createStatement();
                
                JAXBContext jctx = JAXBContext.newInstance(eLog.class);
              
                //Inputstream for the file
                URL stream = new URL("http://10.10.10.3/billbox/bbface.ashx?method=geterror");
                URLConnection uConnection = stream.openConnection();
                DataInputStream dis = new DataInputStream(uConnection.getInputStream());
                
                // marshal object to file input stream
                Unmarshaller um = jctx.createUnmarshaller();


                //eLog st = (eLog) um.unmarshal(fis);
                eLog st = (eLog) um.unmarshal(dis);


                // prints
                System.out.println("Service Source : "+st.getService());
                System.out.println("Channel : "+st.getChannel());
                System.out.println("Transaction Type : "+st.getType());
                System.out.println("Provider Name : "+st.getProvider());
                System.out.println("Pido Account : "+st.getPido());
                System.out.println("Beneficiary ID : "+st.getBenId());
                System.out.println("Error Description : "+st.getDescription());
                System.out.println("Error Date : "+st.getErrorDate());
              

                int insert= ns.executeUpdate("INSERT into error_log(service_source,channel,transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date) "
                        + "VALUES('"+st.getService()+"','"+st.getChannel()+"','"+st.getType()+"','"+st.getProvider()+"','"+st.getPido()+"','"+st.getBenId()+"','"+st.getDescription()+"','"+st.getErrorDate()+"')");
                
               String query = "DELETE error_log FROM error_log INNER JOIN "
                + "(SELECT  min(id) minid, service_source, channel,transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date FROM error_log "
                + "GROUP BY service_source, channel, transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date "
                + "HAVING COUNT(1) > 1 ) AS duplicates ON "
                        + "(duplicates.service_source = error_log.service_source AND duplicates.channel = error_log.channel "
                    + "AND duplicates.transaction_type = error_log.transaction_type AND duplicates.provider_name = error_log.provider_name "
                    + "AND duplicates.pido_account = error_log.pido_account AND duplicates.beneficiary_id = error_log.beneficiary_id "
                    + "AND duplicates.error_description = error_log.error_description AND duplicates.error_date = error_log.error_date "
                    + "AND duplicates.minid <> error_log.id"
                    + ")";
            
            int deploy = duplicate.executeUpdate(query);
                
            }catch(Exception ex){
                Logger.getLogger(JaxbTester.class.getName()).log( 
                           Level.SEVERE, null, ex);
            }
    }
    
    
    public static void main(String args[]){
        
        
        int delay = 1000*1*60; // delay for 1 minute.
        int period = 1000*1*60; // repeat every minute.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                JaxbTester3 ab = new JaxbTester3();
                try {
                    ab.XMLParser();
                } catch (JAXBException ex) {
                    Logger.getLogger(JaxbTester3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JaxbTester3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JaxbTester3.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("doing"); 
            }
        }, delay, period);
        
       /*** try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitor", "root", "");
            
            
        }catch(Exception e){
            Logger.getLogger(JaxbTester.class.getName()).log( 
                           Level.SEVERE, null, e);
        }***/
    }
}