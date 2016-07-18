/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import com.paycom.PaycomService_Service;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimerTask;
import java.util.Timer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;
/**
 *
 * @author Chinyere
 */
public class QueueTasker2 {
  Queue<ErrObj> qe = new LinkedList<ErrObj>();
  TestA element = new TestA();
  List errorList = element.getErrDesc();
  
   
  public QueueTasker2(Queue<ErrObj> qe ) {

        Timer timer = new Timer();
        this.qe=qe;
  }
  
  public void queueM(){
          final String emailMsgTxt      = "This is just a test. Hope it works.";
          final String emailSubjectTxt  = "Alert Sending test";
          final String emailFromAddress = "10.10.10.3";
          final String[] emailList = {"debo_ay@yahoo.co.uk", "dotun_ay@yahoo.co.uk"};
          SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
           
          //current timestamp
          Calendar calendar2 = Calendar.getInstance();
          java.util.Date now = calendar2.getTime();
          SimpleDateFormat dateFormatter2 = new SimpleDateFormat("E, y-M-d h:m:s a z");
          dateFormatter2.format(now);
          calendar2.setTime(now);
          long mills2 = calendar2.getTimeInMillis();
          
          //timestamp of element
          ErrObj ns = qe.peek();
          java.util.Date currentTStamp = ns.getSta();
          Calendar calendar1 = Calendar.getInstance();          
          SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d h:m:s a z");
          dateFormatter.format(currentTStamp);
          calendar1.setTime(currentTStamp);
          long mills1 = calendar1.getTimeInMillis();
          
          //difference between both timestamps 
          long day = mills2 - mills1;
          
          //difference in minutes
          int diffInMin = (int)(day/(60*1000));
          
          //1 hour constant
          final long time_limit = TimeUnit.HOURS.toMinutes(1);
          
          
          
        for(int i=0; i<errorList.size(); i++){
             ErrObj e = (ErrObj)errorList.get(i);
             qe.add(e);
            //System.out.println(e);
            
        }
        
          if(qe.size() >= 5){
              try {
                    //**send alert
                    //**print the size within the queue with their timestamps
                    smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
                } catch (MessagingException ex) {
                    Logger.getLogger(QueueTasker.class.getName()).log(Level.SEVERE, null, ex);
                }
              qe.peek();
              qe.size();
              System.out.println("Succesfully sent mail to all users");
          }
          for(int i=0; i<qe.size(); i++){
              if( diffInMin > time_limit){
                  qe.remove();
              }
          }
  }
  
  public static void main(String args[]){
      
      int delay = 2000*1*60; // delay for 2 minutes.
      int period = 1000*1*60; // repeat every minute.
      Timer timer = new Timer();
      
      timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Queue<ErrObj> qe = new LinkedList<ErrObj>();
                QueueTasker2 ne = new QueueTasker2(qe);
                ne.queueM();
                
                System.out.println("doing"); 
            }
     }, delay, period);
  }
}
