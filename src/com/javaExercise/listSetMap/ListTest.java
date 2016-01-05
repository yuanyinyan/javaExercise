package com.javaExercise.listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuanyin on 16/1/2.
 * 添加备选课程的类
 * 学习ArrayList相关操作
 */
public class ListTest {

    private List<Course> coursesToSelect;//用于存放备选课程

    public ListTest() {
        coursesToSelect = new ArrayList<Course>();
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.testAdd();
        listTest.testGet();
        listTest.testIterator();
    }

    /**
     * 用于往coursesToSelect中添加课程
     */
    public void testAdd() {
        Course course1 = new Course("1", "数据结构");
        coursesToSelect.add(course1);
        Course temp = coursesToSelect.get(0);
        System.out.println("添加了课程:" + temp.getId() + ":" + temp.getName());

        Course course2 = new Course("2", "C语言");
        coursesToSelect.add(0, course2);
        Course temp2 = coursesToSelect.get(0);
        System.out.println("添加了课程:" + temp2.getId() + ":" + temp2.getName());

        Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
//        Collections.addAll(coursesToSelect, courses);
        coursesToSelect.addAll(Arrays.asList(courses));
        Course temp3 = coursesToSelect.get(2);
        Course temp4 = coursesToSelect.get(3);
        System.out.println("添加了两门课程:" + temp3.getId() + ":" + temp3.getName() + ";"
                                   + temp4.getId() + ":" + temp4.getName());

        Course[] courses2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
        coursesToSelect.addAll(2, Arrays.asList(courses2));
        Course temp5 = coursesToSelect.get(2);
        Course temp6 = coursesToSelect.get(3);
        System.out.println("添加了两门课程:" + temp5.getId() + ":" + temp5.getName() + ";" + temp6.getId() + ":" + temp6
                .getName());
    }

    /**
     * 通过循环获取list中的元素
     */
    public void testGet() {
        System.out.println("有如下课程可选:");
        for (Course course : coursesToSelect) {
            System.out.println("课程:" + course.getId() + ":" + course.getName());
        }
    }

    /**
     * 通过迭代器遍历list
     */
    public void testIterator() {
        Iterator iterator = coursesToSelect.iterator();
        System.out.println("有如下课程可选(通过Iterator):");
        while (iterator.hasNext()) {
            Course course = (Course) iterator.next();
            System.out.println("课程:" + course.getId() + ":" + course.getName());
        }
    }

}
