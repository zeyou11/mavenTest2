package com.xz.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int count = 0;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端启动，等待客户端连接");
            while (true){
                socket = serverSocket.accept();
                new ServerThread(socket).start();
                count ++;
                System.out.println("客户端数量:"+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
