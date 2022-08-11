package com.dobrodey.http.socket.idp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket(7777)) {

            byte[] buffer = new byte[512];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(packet);
//            byte[] data = packet.getData();
            System.out.println(new String(buffer).trim());
//            System.out.println(new String(data));
        }
    }
}
