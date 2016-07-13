/**
 * 
 */
package com.alexiesracca.sandbox;

/**
 * @author alexies racca
 * @dateCreated Nov 25, 2015 
 */
public class JavaWhileBreakTest {
    
public static void main(String[] args) {
    
    boolean  x = true;
    System.out.println("before WHIKE");
    while(true){
        System.out.println("before if");
        if(x){
            System.out.println("in if");
            break;
        }
        System.out.println("after break if");
        System.out.println("before  break out");
        break;
    }
}
    

    

}
