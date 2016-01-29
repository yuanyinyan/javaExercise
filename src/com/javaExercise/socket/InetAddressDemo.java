package com.javaExercise.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类,标示IP地址
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名:" + address.getHostName());
        System.out.println("IP地址:" + address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP:" + Arrays.toString(bytes));
        System.out.println(address);

        //根据机器名获取InetAddress
        InetAddress address1=InetAddress.getByName("yuanyindeMacBook-Pro.local");
        System.out.println("计算机名:" + address1.getHostName());
        System.out.println("IP地址:" + address1.getHostAddress());
    }
}
