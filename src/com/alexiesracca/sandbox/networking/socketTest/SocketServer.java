/**
 * 
 */
package com.alexiesracca.sandbox.networking.socketTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author alexies racca
 * @dateCreated Dec 14, 2015 
 */
public class SocketServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("START SERVER");
        // TODO Auto-generated method stub
        String host = "127.0.0.1";
        int port = 8097;
        
        try{
            ServerSocket server = new ServerSocket(port);
            server.setSoTimeout(10000);
            
            Socket socket = null;
            
            while(true){
                try{
                    socket = server.accept();
                    
                    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    
                    System.out.println("Message from client :  " + dataInputStream.readUTF());
                    
                    //Send back message 
                    dataOutputStream.writeUTF("Hello from server: "+ socket.getLocalSocketAddress()+"/"+ socket.getRemoteSocketAddress());
                    socket.close();    
                }catch(SocketTimeoutException e)
                {
                    e.printStackTrace();
                    break;
                }
                
            }
          
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
        System.out.println("END SERVER");
    }

}
