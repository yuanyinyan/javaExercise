package com.javaExercise.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/27.
 */
public class IOUtilTest3 {
    public static void main(String[] args) {
        try {
            IOUtil.copyFile(new File("./copy1.txt"),new File("./copy2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
