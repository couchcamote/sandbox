/**
 * 
 */
package com.alexiesracca.sandbox.exercise;

/**
 * @author alexies racca
 * @dateCreated Dec 1, 2015 
 */
public class ArmstrongNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));

    }
    
    static boolean isArmstrong(int x){
        int current = x;
        int digit = 0;
        int total = 0;
        
        while(current > 0 ){
            digit = current % 10;
            total = total + digit*digit*digit;
            System.out.println("current digit total "+ current + " - "+ digit + " - "+ total);
            current = current / 10;
        }
        
        if (total == x) return true;
        
        return false;
    }

}
