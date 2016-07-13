/**
 * 
 */
package com.alexiesracca.sandbox.networking.socketTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author alexies racca
 * @dateCreated Dec 14, 2015 
 */
public class SocketClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("START CLIENT");
        String host = "127.0.0.1";
        int port = 8097;
        try{
            Socket client = new Socket(host, port);
            OutputStream outStream = client.getOutputStream();
            InputStream inStream = client.getInputStream();
            DataOutputStream dataOutStream = new DataOutputStream(outStream);
            DataInputStream dataInputStream = new DataInputStream(inStream);

            dataOutStream.writeUTF("Connecting from client: "+ client.getLocalSocketAddress()+ "/" + client.getRemoteSocketAddress());
            System.out.println("FROM server "+ dataInputStream.readUTF());            
            
            client.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println("END CLIENT");
    }

}
