
package com.logger;

//import java.sql.*;
import com.paycom.PaycomService_Service;
import java.io.File;
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
/**
 *
 * @author Debo
 */
public class QueueTasker {

  Queue<ErrorRate> qe = new LinkedList<ErrorRate>();
  TestA element = new TestA();
  String err = element.getErr();
  java.util.Date st = element.getTimeStamp();

  public static void main(String args[]) throws Exception{
      
      
      Queue<ErrorRate> qe = new LinkedList<ErrorRate>();
      new QueueTasker(300,qe);
  }
  
  public QueueTasker(int seconds,Queue<ErrorRate> qe ) {
    
    Timer timer = new Timer();
    this.qe=qe;
    timer.schedule(new RemindTask(), seconds * 1000);
  }

  class RemindTask extends TimerTask {
        @Override
        public void run(){
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
          ErrorRate ns = qe.peek();
          Calendar calendar1 = Calendar.getInstance();
          java.util.Date currentTStamp = ns.getSta();
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
          
          /**PaycomService_Service port = new PaycomService_Service();
          port.getPaycomServicePort().parser(port.getPaycomServicePort().generateXML());**/
          
          qe.add(new ErrorRate(err, st));
          if(qe.size() >= 20){
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
    }
  }

  
