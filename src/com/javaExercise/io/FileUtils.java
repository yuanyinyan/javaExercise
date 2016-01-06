package com.javaExercise.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/6.
 * <p/>
 * 列出File的一些常用操作比如过滤,遍历等操作
 */
public class FileUtils {
    /**
     * 列出指定目录下(包括其子目录)的所有文件
     *
     * @param dir
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录:" + dir + "不存在.");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }
//        String[] fileNames=dir.list();
//        for (String fileName : fileNames) {
//            System.out.println(fileName);
//        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }
}
