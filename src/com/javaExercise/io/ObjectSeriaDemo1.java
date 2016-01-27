package com.javaExercise.io;

import java.io.*;

/**
 * Created by yuanyin on 16/1/28.
 */
public class ObjectSeriaDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename="demo/obj.dat";
        //1.对象序列化
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename));
//        Student student=new Student("10001","张三",20);
//        oos.writeObject(student);
//        oos.flush();
//        oos.close();

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename));
        Student student=(Student)ois.readObject();
        System.out.println(student);
        ois.close();

    }
}
