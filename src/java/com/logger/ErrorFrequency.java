/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;


import com.paycom.PaycomService_Service;
import java.text.SimpleDateFormat;
import java.util.*;

class ErrorFrequency  {
    
    public static final void main(String[] args) {
        Queue<ErrObj> pq = new LinkedList<ErrObj>() {};
        
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d h:m:s a z");
        
        TestA element = new TestA();
        List errorList = element.getErrDesc();
        
        
        for(int i=0; i<errorList.size(); i++){
             ErrObj e = (ErrObj)errorList.get(i);
             pq.add(e);
            System.out.println(e);
            
        }
        //System.out.println(pq.peek());
        //System.out.println(pq.size());
        
       /** TestA ea = new TestA();
        List <TestA> as = ea.getErrDesc();
        
        for (TestA t : as){
            //pq.add(t);
            System.out.println(t);
            System.out.println("Addition Successful");
        }**/
        
    }
}
