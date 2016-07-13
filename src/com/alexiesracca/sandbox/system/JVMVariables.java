/**
 * 
 */
package com.alexiesracca.sandbox.system;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author alexies racca
 * @dateCreated Nov 24, 2015 
 */
public class JVMVariables {

    /**
     * @param args
     */
    public static void main(String[] args) {
         Properties p = System.getProperties();
        Enumeration keys = p.keys();
        while (keys.hasMoreElements()) {
          String key = (String)keys.nextElement();
          String value = (String)p.get(key);
          System.out.println(key + ": " + value);
        }

    }

}
