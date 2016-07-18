/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Chinyere
 */
public class JaxbTester2 {
   public static void main(String[] argv) throws Exception {
    int delay = 1000*1*60; // delay for 5 sec.
    int period = 1000*1*60; // repeat every sec.
    Timer timer = new Timer();

    timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        System.out.println("doing"); 
      }
    }, delay, period);
  }
}
