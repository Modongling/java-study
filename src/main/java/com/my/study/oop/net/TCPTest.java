package com.my.study.oop.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPTest {
    public static void main(String[] args) {
        server();

    }
    public static void client() {
        OutputStream os = null;
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
            os = socket.getOutputStream();
            os.write("hello".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void server() {
        InputStream is= null;
        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            //绑定端口
            serverSocket = new ServerSocket(8899);
            //监听连接请求
            socket = serverSocket.accept();
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = is.read(buffer);
            String res = new String(buffer, 0, len);
            System.out.println(socket.getInetAddress().toString() + " " + res);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
