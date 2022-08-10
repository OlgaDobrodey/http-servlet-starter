package com.dobrodey.http.socket.only.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

//Client
public class SocketRunner {
    public static void main(String[] args) throws IOException {
        //http - 80
        //https - 443
        //tcp
        InetAddress inetAddress = Inet4Address.getByName("google.com");
        try (Socket socket = new Socket(inetAddress, 80);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello world");
             byte[] response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
