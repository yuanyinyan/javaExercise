package com.javaExercise.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/27.
 */
public class DosDemo {
    public static void main(String[] args) throws IOException {
        String filename = "demo/dos.dat";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10L);
        dos.writeUTF("中国");//以utf-8格式写入
        dos.writeChars("中国");//以utf-16be格式写入
        dos.close();

        IOUtil.printHex(filename);
    }
}
