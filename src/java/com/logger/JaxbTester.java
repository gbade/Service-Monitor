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
import java.sql.Statement;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.TimerTask;
import java.util.Timer;
import java.util.*;
/**
 *
 * @author Chinyere
 */
public class JaxbTester {
    
    public JaxbTester(int seconds){
        Timer timer = new Timer();
        timer.schedule(new JaxbTester.RemindTask(), seconds * 1000);
    }
    
    class RemindTask extends TimerTask {
        @Override
        public void run(){
          try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitor", "root", "");
            Statement ns=con.createStatement(); 
            JAXBContext jctx = JAXBContext.newInstance(eLog.class);
            // create file writer object
            File f = new File("C:/Users/Chinyere/Documents/NetBeansProjects/Service Monitor/web/WEB-INF/error_log.xml");


            // create new file input stream
            FileInputStream fis = new FileInputStream(f);

            //create Inputstream for the file
            URL stream = new URL("http://10.10.10.3/billbox/bbface.ashx?method=geterror");
            URLConnection uConnection = stream.openConnection();
            DataInputStream dis = new DataInputStream(uConnection.getInputStream());

            // marshal object to file input stream
            Unmarshaller um = jctx.createUnmarshaller();


            eLog st = (eLog) um.unmarshal(fis);
            //eLog st = (eLog) um.unmarshal(dis);


            // prints
            System.out.println("Service Source : "+st.getService());
            System.out.println("Channel : "+st.getChannel());
            System.out.println("Transaction Type : "+st.getType());
            System.out.println("Provider Name : "+st.getProvider());
            System.out.println("Pido Account : "+st.getPido());
            System.out.println("Beneficiary ID : "+st.getBenId());
            System.out.println("Error Description : "+st.getDescription());
            System.out.println("Error Date : "+st.getErrorDate());

            int i= ns.executeUpdate("INSERT into error_log(service_source,channel,transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date) "
                    + "VALUES('"+st.getService()+"','"+st.getChannel()+"','"+st.getType()+"','"+st.getProvider()+"','"+st.getPido()+"','"+st.getBenId()+"','"+st.getDescription()+"','"+st.getErrorDate()+"')");

        }catch(Exception ex) {
            ex.printStackTrace();
        } 
       System.exit(0); 
     }
    }
    public static void main(String[] args) {
        JaxbTester reminderBeep = new JaxbTester(60);
    }
}
