package com.dobrodey.http.socket.one.request;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//Client
public class SocketRunner {
    public static void main(String[] args) throws IOException {
        //http - 80
        //https - 443
        //tcp
        InetAddress inetAddress = Inet4Address.getByName("localhost");
        try (Socket socket = new Socket(inetAddress, 7777);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in);) {

            String request = scanner.nextLine();
            outputStream.writeUTF(request);
            System.out.println("Response from server: " + inputStream.readUTF());
        }
    }
}
