/**
 * 
 */
package com.alexiesracca.sandbox.cipher;

import org.jasypt.util.text.BasicTextEncryptor; 

/**
 * @author alexies racca
 * @dateCreated Dec 17, 2015 
 */
public class EncrypterMessenger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        basicTestEncryptor2();

    }
    
public static void basicTestEncryptor2() { 
        
            String PLAIN_TEXT = "TESTTEXT";

        String saltPwd = "S0m3SecPwd";
        String saltPwd2 = "S0m3SecPwd";
        

            BasicTextEncryptor encryptor1 = new BasicTextEncryptor(); 
            BasicTextEncryptor encryptor2 = new BasicTextEncryptor();
            
            encryptor1.setPassword(saltPwd);
            encryptor2.setPassword(saltPwd2);
 
            String encrypted1 = encryptor1.encrypt(PLAIN_TEXT); 
           
            System.out.println(encrypted1);
            
            String decrypted2 = encryptor2.decrypt(encrypted1); 
            
            
            
            System.out.println(decrypted2);


    } 


}
