/**
 * 
 */
package com.alexiesracca.sandbox.exercise;

import java.beans.EventHandler;
import java.util.Comparator;

/**
 * @author alexies racca
 * @dateCreated Dec 17, 2015 
 */
public class NumericTest {

    /**
     * @param <ActionEvent>
     * @param args
     */
    public static <ActionEvent> void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 1_000_00;
        int y = 2_888_999;
        System.out.println(x+y);
        
        Comparator<String> c = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return 0;
            }
            
            
            
        };
        


    }

}
