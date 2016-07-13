/**
 * 
 */
package com.alexiesracca.sandbox.qr;

/**
 * @author alexies racca
 * @dateCreated Mar 18, 2016 
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
 
public class QRCodeDecoder {
 
    public static void main(String[] args) {
        System.out.println("Current DIR :"+ System.getProperty("user.dir"));
        String saveDir=System.getProperty("user.dir");
        String fileName = "generated.png";
        
        if(args.length == 0)
        {
            System.out.println("QRGenerator <TEXT> <optional FILENAME> <optional DIR PATH>");
            return;
        }
       
        String myCodeText = args[0];
        
        if(args.length > 1){
            fileName = args[1];
        }
       
        
        if(args.length > 1){
            saveDir = args[1];
        }

        
        String filePath = saveDir+"/"+fileName;
        

        int size = 400;
        String fileType = "png";
        
        
        System.out.println("Text: "+ myCodeText);
        System.out.println("Filename: "+ filePath);
        
        File myFile = new File(filePath);
        try {
            Hashtable<DecodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<DecodeHintType, ErrorCorrectionLevel>();
            hintMap.put(DecodeHintType.TRY_HARDER, ErrorCorrectionLevel.L);
            
           InputStream is = new BufferedInputStream(new FileInputStream(myFile));
            
            BufferedImage image = ImageIO.read(is);

            BinaryBitmap binaryMap = new BinaryBitmap(new GlobalHistogramBinarizer(new BufferedImageLuminanceSource(image)));

          //decode the barcode
          QRCodeReader reader = new QRCodeReader();

          Result result;
          try {
           result = reader.decode(binaryMap, hintMap);
          } catch (ReaderException e) {
           //the data is improperly formatted

          }

          byte[] b = result.getRawBytes();
          System.out.println(b);

            
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nYou have successfully created QR Code.");
        System.out.println("Location: "+ filePath);
    }       
}