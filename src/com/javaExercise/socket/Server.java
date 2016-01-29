package com.javaExercise.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的socket通信,实现用户登录
 * 服务器端
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class Server {

    public static void main(String[] args) {
        try {
            //1.创建一个服务器端socket,即ServerSocket,指定绑定的端口,并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket;
            int count = 0;
            System.out.println("******服务器即将启用,等待客户端连接*******");

            while (true) {
                //调用accept()方法开始监听,等待客户端连接
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端数量:" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP:" + address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
