package com.javaExercise.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/27.
 */
public class IOUtilTest3 {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            IOUtil.copyFile(new File("demo/copy1.txt"),new File("demo/copy2.txt"));
//            IOUtil.copyFileByBuffer(new File("demo/copy1.txt"),new File("demo/copy3.txt"));
//            IOUtil.copyFileByByte(new File("demo/copy1.txt"), new File("demo/copy4.txt"));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
