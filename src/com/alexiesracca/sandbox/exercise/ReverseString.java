/**
 * 
 */
package com.alexiesracca.sandbox.exercise;

/**
 * @author alexies racca
 * @dateCreated Dec 1, 2015 
 */
public class ReverseString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverse(args[0]));

    }

    static String  reverse(String s){
        
        int start = 0;
        int end = s.length() - 1;
        char[] reverseCharArray =  s.toCharArray();        
        while(start <= end){
            char tmp =s.charAt(start);
            reverseCharArray[start] = reverseCharArray[end];
            reverseCharArray[end] = tmp;
            start++;
            end--;
        }

        
        return new String(reverseCharArray);
    }
    
}
