package com.javaExercise.io;

import java.io.*;

/**
 * Created by yuanyin on 16/1/27.
 */
public class IsrAndOsrDemo {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream("demo/copy1.txt"));
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("demo/copy5.txt"));
//        int c;
//        while ((c = in.read()) != -1) {
//            System.out.print((char) c);
//        }

        char[] buffer = new char[8 * 1024];
        int c;
        /**
         * 批量读取,放入buffer这个字符数组,
         * 从第0个位置开始放置,最多放buffer.length个,
         * 返回读到的字符的个数.
         */
        while ((c = in.read(buffer, 0, buffer.length)) != -1) {
//            for (int i = 0; i < c; i++) {
//                System.out.print(buffer[i]);
//            }
            String s = new String(buffer, 0, c);
            System.out.print(s);
            out.write(buffer, 0, c);
            out.flush();
        }
        in.close();
        out.close();
    }
}
