package com.javaExercise.io;

import java.io.UnsupportedEncodingException;

/**
 * Created by yuanyin on 16/1/6.
 * 测试java编码
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "袁殷ABC";
        byte[] bytes1 = s.getBytes();//使用编译器默认的编码方式(utf-8)
        for (byte b : bytes1) {
            //把字节(转换成int)以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
        byte[] bytes2 = s.getBytes("gbk");
        //gbk编码中文占2个字节,英文占1个字节
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
        byte[] bytes3 = s.getBytes("utf-8");
        //utf-8编码中文占3个字节,英文占1个字节
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
        //java是双字节编码 utf-16be
        byte[] bytes4 = s.getBytes("utf-16be");
        //utf-16be编码中文占2个字节,英文占2个字节
        for (byte b : bytes4) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
        /**
         * 编码和解码要使用相同的编码方式,否则会出现乱码
         */
        String s2 = new String(bytes2);
        System.out.println(s2);

    }
}
