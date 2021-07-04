package com.my.study.oop.net;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UdpTest {
    public static void main(String[] args) {
        send();
    }

    public static void send() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);
            DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8899);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }

    public static void receive() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8899);
            byte[] buffer = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            String res = new String(dp.getData(), 0, dp.getLength());
            System.out.println(dp.getAddress() + " " + res);
        } catch (SocketException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
