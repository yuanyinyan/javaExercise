package com.javaExercise.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基于UDP的用户登录
 * 服务器端
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8801);
        System.out.println("*******服务器端已经启动,等待客户端发送数据*******");

        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        int count = 0;
        while (true) {
            socket.receive(packet);//此方法在接受到数据包之前会一直阻塞

            UDPServerThread thread = new UDPServerThread(socket, packet, data);
            thread.start();
            count++;
            System.out.println("当前客户端数量:" + count);
        }
    }
}
