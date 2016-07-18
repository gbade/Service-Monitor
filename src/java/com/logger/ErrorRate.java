/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

/**
 *
 * @author Chinyere
 */
import com.paycom.PaycomService_Service;
import java.text.SimpleDateFormat;
import java.util.*;

class ErrorRate  {
    final String error;
    final Date sta;
 
    public ErrorRate(String p, Date n) {
        error = p;
        sta = n;
    }
 
    public String toString() {
        return error + ", " + sta;
    }
 
    public String getReport(){
        return error;
    }
    public Date getSta(){
        return sta;
    }
 
 
    public static final void main(String[] args) {
        PriorityQueue<ErrorRate> pq = new PriorityQueue<ErrorRate>();
        
        
        //SendMailUsingAuthentication sendMail = new SendMailUsingAuthentication(from, to, subject, message);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d h:m:s a z");
        
        /**PaycomService_Service port = new PaycomService_Service();
        String s = port.getPaycomServicePort().generateXML();
        port.getPaycomServicePort().parser(s);**/
        
        TestA element = new TestA();
        String err = element.getErr();
        Date st = element.getTimeStamp();
        ErrorRate e = new ErrorRate(err, st);
        pq.add(e);
        
        
        System.out.println(pq.peek());
        System.out.println(pq.size());
        System.out.println("Addition Successful");
        //System.out.println(s);
    }
}
