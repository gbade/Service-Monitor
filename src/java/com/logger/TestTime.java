/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Chinyere
 */
public class TestTime {
    public static void main(String args[]){
        final long time_limit = TimeUnit.HOURS.toMinutes(1);
        Calendar cally = Calendar.getInstance();
        
        long hr = cally.getTimeInMillis();
        
        long sr = cally.get(Calendar.HOUR_OF_DAY);
        long diffHours = hr/(60*60*1000);
        //formatter to be used for current timestamp
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d h:m:s a z");
        System.out.println("Format 2:   " + dateFormatter.format(now));
        //end of 
        
        //formatter for element timestamp. a test
        Calendar cale = Calendar.getInstance();
        Date t_stamp = cale.getTime();
        SimpleDateFormat dateFormatter2 = new SimpleDateFormat("y-M-d h:m:s a ");
        System.out.println("Format 2:   " + dateFormatter2.format(t_stamp));
        
        

        //end of
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.set(2007, 12, 30);
        calendar2.setTime(now);
        long milis1 = calendar1.getTimeInMillis();
        long milis2 = calendar2.getTimeInMillis();
        long day = milis2 - milis1;

        long diffH = day / (60 * 60 * 1000);



        System.out.println( time_limit+ "," + hr+ "," + sr + "," + diffHours + "," + now);
        cally.add(Calendar.HOUR_OF_DAY, -1);
        System.out.println((hr - cally.getTimeInMillis()) + "," + cally.get(Calendar.HOUR_OF_DAY));
        System.out.println(diffH);
    }
}
