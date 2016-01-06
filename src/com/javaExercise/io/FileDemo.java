package com.javaExercise.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/6.
 */
public class FileDemo {

    public static void main(String[] args) {
//        File file=new File("./test");
//        System.out.println(file.exists());
//        if (!file.exists()){
//            file.mkdir();
//        }else {
//            file.delete();
//        }

        File file1=new File("./test.txt");
        if (!file1.exists()){
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file1.delete();
        }

        System.out.println(file1);
    }
}
