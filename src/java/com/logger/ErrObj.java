/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger;

import java.util.Date;

/**
 *
 * @author Debo
 */
public class ErrObj{
    final String error;
    final Date sta;
 
    //initialize constructor
    public ErrObj(){
        super();
        this.error = null;
        this.sta = null;
    }
    public ErrObj(String p, Date n) {
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

    /**@Override
    public int compareTo(Object o) {
        ErrObj e = (ErrObj) o;
        int result = this.getSta().compareTo(e.getSta());
        return result;
    }**/
}
