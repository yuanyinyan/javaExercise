package com.javaExercise.io;

import java.io.Serializable;

/**
 * Created by yuanyin on 16/1/28.
 */
public class Student implements Serializable{
    private String stuNo;
    private String stuName;
    private int stuSge;

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
}
