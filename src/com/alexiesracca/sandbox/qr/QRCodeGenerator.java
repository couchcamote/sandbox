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
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
 
public class QRCodeGenerator {
 
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
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText,BarcodeFormat.QR_CODE, size, size, hintMap);
            int width = byteMatrix.getWidth();
            BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
 
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, width);
            graphics.setColor(Color.BLACK);
 
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, myFile);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nYou have successfully created QR Code.");
        System.out.println("Location: "+ filePath);
    }       
}