package com.javaExercise.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/28.
 */
public class FrAndFwDemo {
    /**
     * FileReader与FileWriter是直接对文件操作,
     * 不能解决编码不同的问题.
     * 当编码不同时,应使用InputStreamReader与OutputStreamWriter
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("demo/copy1.txt");
        FileWriter fw = new FileWriter("demo/copy5.txt");
        char[] buffer = new char[8 * 1024];
        int c;
        while ((c = fr.read(buffer, 0, buffer.length)) != -1) {
            String s = new String(buffer, 0, c);
            System.out.println(s);
            fw.write(buffer, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
