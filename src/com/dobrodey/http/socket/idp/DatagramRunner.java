package com.dobrodey.http.socket.idp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

//Client -- the client does not check for the existence of the service
public class DatagramRunner {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = Inet4Address.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
// ----> [buffer] on one machine can be port as tcp as idp
//            byte[] bytes = new byte[512];
            byte[] bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagramSocket.send(packet);   //send package

        }
    }
}
