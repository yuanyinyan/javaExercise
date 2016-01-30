package com.javaExercise.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 基于UDP用户登录
 * 客户端
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8801;
        byte[] data = "用户名:admin;密码:123456789".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        socket.receive(packet2);
        String reply = new String(data2, 0, packet2.getLength());
        System.out.println("我是客户端,服务器说:" + reply);

        socket.close();
    }
}
