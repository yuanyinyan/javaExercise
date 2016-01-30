package com.javaExercise.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 基于UDP服务器线程处理类
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class UDPServerThread extends Thread {
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    byte[] data;

    public UDPServerThread(DatagramSocket socket, DatagramPacket packet, byte[] data) {
        this.socket = socket;
        this.packet = packet;
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        try {
            String info = new String(data, 0, packet.getLength());
            System.out.println("我是服务器,客户端说:" + info);

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎您".getBytes();
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            socket.send(packet2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
        }
    }
}
