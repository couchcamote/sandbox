/**
 * 
 */
package com.alexiesracca.sandbox.exercise;

/**
 * @author alexies racca
 * @dateCreated Dec 1, 2015 
 */
public class ChangeCount {

    final static int P1000 = 1000;
    final static int P500 = 500;
    final static int P200 = 200;
    final static int P100 = 100;
    final static int P50 = 50;
    final static int P20 = 20;
    final static int P10 = 10;
    final static int P5 = 5;
    final static int P1 = 1;
    final static float P0_5 = (float)0.5;
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        change(74300.790d);

    }

    static void change(double amtf){
        
        int amt = (int)amtf;
        int cents = (int)(100 * (amtf - (double)amt));
        
        System.out.println(cents + " x cents");
        System.out.println(amtf  + " x (amtf ");
        System.out.println(((double)amt) + " x ( (float)amt))");
        System.out.println((amtf - (double)amt) + " x (amtf - (float)amt))");
        
        if(amt / P1000 > 0) {
            int pcs = amt / P1000;
            System.out.println(pcs + " x P1000");
            amt = amt % P1000;
        }
        
        if(amt / P500 > 0) {
            int pcs = amt / P500;
            System.out.println(pcs + " x P500");
            amt = amt % P500;
        }
        
        if(amt / P200 > 0) {
            int pcs = amt / P200;
            System.out.println(pcs + " x P200");
            amt = amt % P200;
        }
        
        if(amt / P100 > 0) {
            int pcs = amt / P100;
            System.out.println(pcs + " x P100");
            amt = amt % P100;
        }
        
        if(amt / P50 > 0) {
            int pcs = amt / P50;
            System.out.println(pcs + " x P50");
            amt = amt % P50;
        }
        
        if(amt / P20 > 0) {
            int pcs = amt / P20;
            System.out.println(pcs + " x P20");
            amt = amt % P20;
        }
        
        if(amt / P10 > 0) {
            int pcs = amt / P10;
            System.out.println(pcs + " x P10");
            amt = amt % P10;
        }
        
        if(amt / P5 > 0) {
            int pcs = amt / P5;
            System.out.println(pcs + " x P5");
            amt = amt % P5;
        }
        
        if(amt / P1 > 0) {
            int pcs = amt / P1;
            System.out.println(pcs + " x P1");
            amt = amt % P1;
        }
        
        System.out.println("cents "+ cents);
        
        if(cents / 50 > 0) {
            int pcs = cents / 50;
            System.out.println(pcs + "x Cents 50");
            cents = cents % 50;
        }
        
        if(cents / 25 > 0) {
            int pcs = cents / 25;
            System.out.println(pcs + "x Cents 25");
            cents = cents % 25;
        }
        
        if(cents / 1 > 0) {
            int pcs = cents / 1;
            System.out.println(pcs + "x Cents 1");
            cents = cents % 1;
        }
        
        
    }
    
}
