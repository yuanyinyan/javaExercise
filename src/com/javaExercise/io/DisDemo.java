package com.javaExercise.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/27.
 */
public class DisDemo {
    public static void main(String[] args) throws IOException {
        String filename = "demo/dos.dat";
        DataInputStream dis = new DataInputStream(new FileInputStream(filename));
        IOUtil.printHex(filename);
        System.out.println();
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readLong());
        System.out.println(dis.readUTF());
        System.out.println(dis.readChar());
    }
}
