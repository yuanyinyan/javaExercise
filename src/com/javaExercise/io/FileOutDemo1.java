package com.javaExercise.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/27.
 */
public class FileOutDemo1 {
    public static void main(String[] args) throws IOException {
        //如果文件不存在,则直接创建,如果存在,删除后创建
        FileOutputStream out = new FileOutputStream("./out.dat");
        out.write('A');//写出'A'的低8位
        out.write('B');//写出'B'的低8位
        int a = 100;//write只能写8位,写一个int需要写4次,每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] gbk="中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtil.printHex("./out.dat");
    }
}
