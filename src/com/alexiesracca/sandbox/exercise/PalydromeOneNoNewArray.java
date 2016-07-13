/**
 * 
 */
package com.alexiesracca.sandbox.exercise;

/**
 * @author alexies racca
 * @dateCreated Dec 1, 2015 
 */
public class PalydromeOneNoNewArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(palindrome("pangit"));
        System.out.println(palindrome("tiririt"));
        System.out.println(palindrome("nakakapagpabagabag"));
        System.out.println(palindrome("anutforajaroftuna"));
    }

    static boolean palindrome(String s){
        
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
           // System.out.println(s.charAt(start) + " " + s.charAt(end));
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        
        return true;
    }
    
}
