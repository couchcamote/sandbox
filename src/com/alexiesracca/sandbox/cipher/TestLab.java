/**
 * 
 */
package com.alexiesracca.sandbox.cipher;

import java.math.BigInteger;

import org.jasypt.digest.StandardByteDigester;
import org.jasypt.digest.StandardStringDigester;

/**
 * @author alexies racca
 * @dateCreated Apr 6, 2016 
 */
public class TestLab {

    /**
     * @param args
     */
    public static void main(String[] args) {
                
        // TODO Auto-generated method stub
        //test4();
       // DigesterTest();
        testEnc();

    }
    
    private static void test1(){
        
        String text = "alexies racca";
        System.out.println(text);
        byte[] orBA = text.getBytes();
        BigInteger numText = new BigInteger(orBA);
        System.out.println(numText);
        byte[] arrayByte = numText.toByteArray();
        System.out.println(arrayByte);
        String recovered = new String(arrayByte);
        System.out.println(recovered);
    }
    
    private static void test2(){
        String text = "alexies racca";
        System.out.println(text);
        byte[] orBA = text.getBytes();
        BigInteger numText = new BigInteger(orBA);
        System.out.println(numText);
        byte[] arrayByte = numText.toByteArray();
        System.out.println(arrayByte);
        String recovered = new String(arrayByte);
        System.out.println(recovered);
    }
    
    private static void test3(){
        
        System.out.println(Integer.toBinaryString(999999999));
        
        byte b1 = (byte) 129;
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        System.out.println(s1); // 10000001

        byte b2 = (byte) 2;
        String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 00000010
        
    
    }
    
    private static void test4(){
        String alex = "36";
        BigInteger bi = new BigInteger(alex);
        System.out.println(bi);
        
         bi = new BigInteger(alex.getBytes());
        System.out.println(bi);
        
        
        System.out.println();
    }
    
    private static void DigesterTest(){
        String password = "password";
        String inputPassword = "password";
        
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-1");   // optionally set the algorithm
        digester.setIterations(50000);  // increase security by performing 50000 hashing iterations
        String digest = digester.digest(password);
        System.out.println("digested "+ digest);
        if (digester.matches(inputPassword, digest)) {
          System.out.println("correct");
        } else {
            System.out.println("not");
        }
    }
    
    private static void ByteDigesterTest(){
        String password = "password";
        String inputPassword = "password";
        
       StandardByteDigester  digester = new StandardByteDigester();
        digester.setAlgorithm("SHA-1");   // optionally set the algorithm
        digester.setIterations(50000);  // increase security by performing 50000 hashing iterations
        byte[] digest = digester.digest(password.getBytes());
        if (digester.matches(inputPassword.getBytes(), digest)) {
          System.out.println("correct");
        } else {
            System.out.println("not");
        }
    }
    
    private static void testEnc(){
        String orig = "leeen";
        String al = Encrypt.encrypt(orig, "alexies");
        
        System.out.println("AAA "+ al);
        
       String ddd =  Encrypt.decrypt(al, "alexies");
        if(ddd.equals(orig)){
            System.out.println("YEEEE");
        }else
        {
            System.out.println("NOOO");
        }
    }

}
