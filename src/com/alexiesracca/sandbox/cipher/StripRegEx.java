package com.alexiesracca.sandbox.cipher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.salt.RandomSaltGenerator;

import com.alexiesracca.sandbox.cipher.Encrypt;

/**
 * 
 */

/**
 * @author alexies racca
 * @dateCreated Apr 1, 2016 
 */
public class StripRegEx {

    /**
     * @param args
     */
    public static void main(String[] args) {
/*        String pwd = "XXXEnc(sdasdasdas)DDWD";
        Pattern p = Pattern.compile("[E|e][N|n][C|c]\\((.*?)\\)");
        Matcher m = p.matcher(pwd);

        System.out.println("matches "+ m.matches());
        
        while(m.find()) {
            System.out.println(m.group(1));
        }
        //System.out.println("matches"+ " " + b + " ccc "+ m.group(1));
        
        */
        
   String orig = "lololoo";
        
       String enc = Encrypt.getEncryptedPassword(orig, "alexies", null, "PBEWITHMD5ANDTRIPLEDES", RandomSaltGenerator.DEFAULT_SECURE_RANDOM_ALGORITHM, 0);
       
   /*     
       String dec = "";
        
        try {
            dec = EncryptionUtility.getDecryptedPassword("Enc("+enc+")", null, EncryptionUtility.DEFAULT_KEY_ENV_VAR, "PBEWITHMD5ANDTRIPLEDES", EncryptionUtility.DEFAULT_SALT_GENERATOR, 0);
        }
        catch (NoKeyphraseProvidedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (PasswordPatternIncorrect e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(orig.equalsIgnoreCase(dec)){
            System.out.println("YeHeHEHEHE");
        }
        else{
            System.out.println("NOOOOO!");
        }*/

    }

}
