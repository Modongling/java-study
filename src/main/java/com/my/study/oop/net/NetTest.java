package com.my.study.oop.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {
    public static void main(String[] args) {
        try {
            //ip
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
            //端口号+ip --- Socket
            //TCP/IP (UDP TCP)
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
