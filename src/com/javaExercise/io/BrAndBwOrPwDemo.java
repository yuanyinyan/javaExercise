package com.javaExercise.io;

import java.io.*;

/**
 * Created by yuanyin on 16/1/28.
 */
public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        //对文件进行读写操作
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demo/copy1.txt")));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("demo/copy6.txt")));
        PrintWriter pw=new PrintWriter("demo/copy7.txt");

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);//一次读一行,不识别换行
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
            pw.println(line);
            pw.flush();
        }
        br.close();
//        bw.close();
        pw.close();
    }
}
