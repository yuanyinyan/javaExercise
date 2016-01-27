package com.javaExercise.io;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yuanyin on 16/1/28.
 */
public class Student implements Serializable {
    private String stuNo;
    private String stuName;
    private transient int stuSge;//该元素不会进行jvm默认的序列化,也可以自己完成这个元素的序列化

    public Student() {
    }

    public Student(String stuNo, String stuName, int stuSge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSge = stuSge;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuSge() {
        return stuSge;
    }

    public void setStuSge(int stuSge) {
        this.stuSge = stuSge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSge=" + stuSge +
                '}';
    }

    /**
     * 自己完成元素的序列化,
     * 参考ArrayList的writeObject方法
     *
     * @param s
     * @throws java.io.IOException
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();//把jvm能序列化的元素进行序列化操作
        s.writeInt(stuSge);//自己完成stuSge的序列化
    }

    /**
     * 反序列化 自己进行序列化的元素
     *
     * @param s
     * @throws java.io.IOException
     * @throws ClassNotFoundException
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();//把jvm默认能反序列化的元素进行反序列化
        this.stuSge = s.readInt();//自己完成stuSge的反序列化
    }

    /**
     * ArrayList源码使用transient进行序列化的优化,
     * 只序列化有效元素,从而提高性能
     */
}
