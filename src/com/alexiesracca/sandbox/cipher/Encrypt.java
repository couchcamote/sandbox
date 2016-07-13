/**
 * 
 */
package com.alexiesracca.sandbox.cipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.salt.SaltGenerator;



/**
 * @author alexies racca
 * @dateCreated Mar 29, 2016
 */
public class Encrypt {

    private static String[] EncryptorAlgorithms = new String[]{"AES", "AESWARP", "ARCFOUR", "BLOWFISH", "DES",
                                                               "DESEDE", "DESEDEWARP", "PBEWITHMD5ANDDES",
                                                               "PBEWITHMD5ANDTRIPLEDES", "PBEWITHSHA1ANDDESEDE",
                                                               "PBEWITHSHA1ANDRC2_40", "RC2"};
    

    public static final int DEFAULT_KEY_OBT_ITER = 6;    

    private static String fileToRead = "";

    private static String algo = EncryptorAlgorithms[7];

    private static String text = "";

    private static String plainText = "";

    private static String encryptedText = "";

    private static String key = null;

    private static boolean deleteSrc = false;

    private static String toFile = null;

    private static String writeString = "";

    private static String method = "e";

    private static File f;

    public static void main(String args[]) {

        if (args.length < 1) {
            printUsage();
            return;
        }

        extractParameters(args);
        execute();

    }

    /**
     * @param args
     */
    private static void extractParameters(String[] args) {
        String firstParmArray[] = args[0].split("=", 2);

        if (firstParmArray.length == 1) {
            text = firstParmArray[0];
        }
        else {
            text = firstParmArray[1];
            method = firstParmArray[0].toLowerCase();
        }

        if (args.length > 1) {
            for (int y = 1; y < args.length; y++) {
                String optargs[] = args[y].split("=", 2);
                if (optargs.length == 2) {
                    String mode = optargs[0];
                    String value = optargs[1];

                    if (mode.equalsIgnoreCase("type")) {
                        algo = EncryptorAlgorithms[Integer.parseInt(value)];
                    }
                    else if (mode.equalsIgnoreCase("tofile")) {
                        toFile = value;
                    }
                    else if (mode.equalsIgnoreCase("tofiled")) {
                        toFile = value;
                        deleteSrc = true;
                    }

                    else if (mode.equalsIgnoreCase("key")) {
                        key = value;
                    }
                }
                else {
                    System.out.println("Invalid Parameter: "+ args[y]);
                }
            }
        }

        if (key == null || key.isEmpty()) {
            char[] keychars;

            try {
                while ((keychars = System.console().readPassword("Enter keyphrase:")).length == 0) {}
                key = new String(keychars);
            }
            catch (Exception e) {
                System.out.println("Keyphrase is required if not from console : key=<keyphrase>");
                System.exit(1);
            }
        }

    }

    /**
     * 
     */
    private static void execute() {
        // OK
        if ("e".equalsIgnoreCase(method)) {
            plainText = text;
            System.out.println("Plaintext: " + plainText);            
            encryptedText = encrypt(plainText, key);
            writeString = encryptedText;
            
            if(!shouldNotDisplayResult())
            {
                System.out.println("Encrypted Text: " + encryptedText);
            }
            
            writeToFile();
        }
        else if ("d".equalsIgnoreCase(method)) {
            System.out.println("Encrypted Text: " + text);
            encryptedText = text;            
            plainText = decrypt(encryptedText, key);
            
            
            if(!shouldNotDisplayResult())
            {
                System.out.println("Encrypted Text: " + encryptedText);
            }
            
            writeString = plainText;
            writeToFile();
        }
        else if ("ef".equalsIgnoreCase(method)) {
            fileToRead = text;
            plainText = getTextFromFile(fileToRead);
            encryptedText = encrypt(plainText, key);
            writeString = encryptedText;
            
            System.out.println("Reading from file: " + fileToRead);
            

            if(!shouldNotDisplayResult())
            {
                System.out.println("Encrypted Text: " + encryptedText);
            }
            
            writeToFile();

            if (deleteSrc) {
                f.delete();
            }
        }
        else if ("df".equalsIgnoreCase(method)) {
            fileToRead = text;
            encryptedText = getTextFromFile(fileToRead);
            plainText = decrypt(encryptedText, key);
            writeString = plainText;
            
            System.out.println("Reading from file: " + fileToRead);
            
            if(!shouldNotDisplayResult())
            {
                System.out.println("Plaintext: " + plainText);
            }

            writeToFile();

            if (deleteSrc) {
                f.delete();
            }

        }
    }

    /**
     * @param file
     * @return
     */
    private static String getTextFromFile(String file) {

        f = getFile(file);

        if (f == null) {
            return null;
        }

        FileReader fr;
        BufferedReader bufferedReader;
        try {
            fr = new FileReader(f);
            bufferedReader = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line+"\n");
            }

            file = sb.toString();

            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println("Some Error");
            System.exit(1);
        }
        finally {

        }
        return file;
    }

    private static File getFile(String fileLoc) {
        File f = new File(fileLoc);
        if (f.exists()) {
            if (f.isDirectory()) {
                return null;
            }
            else {
                return f;
            }
        }
        else {
            f = new File(System.getProperty("user.dir") + "/" + fileLoc);
            if (f.exists()) {
                return f;
            }
        }

        return null;
    }

    private static void writeToFile() {
        if (toFile != null) {
            File f = new File(toFile);

            FileWriter fr;
            try {
                fr = new FileWriter(f);
                fr.write(writeString);
                fr.close();
                System.out.println("Result written to file: "+ f.getAbsolutePath());
            }
            catch (IOException e) {
                System.out.println("Error writing to file");
                System.exit(1);
            }
        }
    }
    
    private static boolean shouldNotDisplayResult(){
        if (toFile != null) {
            File f = new File(toFile);
           if( f.canWrite() ) return true;
        }
        return false;
    }


    private static void printUsage() {

        System.out.println("[USAGE]");
        System.out.println("e=<PLAINTEXT> or ef=<PLAINTEXT FILE LOCATION>  => To encrypt text or file");
        System.out.println("d=<ENCRYPTED TEXT> |  | df=<ENCRYPTEDTXT FILE LOCATION>   (Required) => to decrypt text or file");
        // System.out.println("key=<KEYPHRASE> (Optional, will be prompted later) ");

        /*
         * System.out.println("type=<ALGORITH Number>  | Optional "); for(int i = 0; i < EncryptorAlgorithms.length
         * ;i++){ System.out.println("\t"+(i+1)+") "+ EncryptorAlgorithms[i]); }
         */

        System.out
            .println("tofile=<FILE NAME TO SAVE RESULT> | tofiled=<FILE NAME TO SAVE RESULT, DELETE SOURCE FILE IF ANY> (Optional) => write result to a file ");
    }

 
    public static String encrypt(String plainText, String key) {

        if (plainText.isEmpty()) {
            System.err.println("Empty or invalid text");
            System.exit(1);
        }

        if (key.isEmpty()) {
            System.err.println("Keyphrase Empty or invalid");
            System.exit(1);
        }

        StandardPBEStringEncryptor sse = new StandardPBEStringEncryptor();

        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");

        SaltGenerator saltGenerator = new RandomSaltGenerator(RandomSaltGenerator.DEFAULT_SECURE_RANDOM_ALGORITHM);
            config.setPassword(key);


        if (DEFAULT_KEY_OBT_ITER > 0) {
            sse.setKeyObtentionIterations(DEFAULT_KEY_OBT_ITER);
        }

        sse.setConfig(config);
        sse.setSaltGenerator(saltGenerator);

        return sse.encrypt(plainText);
    }

    public static String decrypt(String encryptedText, String key) {
        
        if(encryptedText.equals("fXsp9wf0IbYNsn3Tm6t7gw=="))
        {
            System.out.println("DSDSD");
        }

        if (encryptedText.isEmpty()) {
            System.out.println("Empty or invalid text");
            System.err.println("Empty or invalid text");
            System.exit(1);
        }

        if (key.isEmpty()) {
            System.out.println("Keyphrase Empty or invalid");
            System.err.println("Keyphrase Empty or invalid");
            System.exit(1);
        }


        StandardPBEStringEncryptor sse = new StandardPBEStringEncryptor();

        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");

        SaltGenerator saltGenerator = new RandomSaltGenerator(RandomSaltGenerator.DEFAULT_SECURE_RANDOM_ALGORITHM);
            config.setPassword(key);


        if (DEFAULT_KEY_OBT_ITER > 0) {
            sse.setKeyObtentionIterations(DEFAULT_KEY_OBT_ITER);
        }

        sse.setConfig(config);
        sse.setSaltGenerator(saltGenerator);

        return sse.decrypt(encryptedText);
    }

}
