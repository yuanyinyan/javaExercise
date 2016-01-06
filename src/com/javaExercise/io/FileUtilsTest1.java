package com.javaExercise.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/6.
 */
public class FileUtilsTest1 {
    public static void main(String[] args) throws IOException {
        FileUtils.listDirectory(new File("./"));
    }
}
