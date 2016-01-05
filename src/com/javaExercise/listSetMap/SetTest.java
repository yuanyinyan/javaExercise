package com.javaExercise.listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yuanyin on 16/1/2.
 * 学生选课的类
 * 学习HashSet相关操作
 */
public class SetTest {
    private List<Course> coursesToSelect;//用于存放备选课程
    private Scanner scanner;
    private Student student;

    public SetTest() {
        this.coursesToSelect = new ArrayList<Course>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.testAdd();
        setTest.testGet();
        setTest.testListContains();
//        setTest.createStudentAndSelectCourses();
//        setTest.testSetContains();

//        setTest.testForEachForSet(student);
    }

    /**
     * 创建学生对象并选课
     */
    public void createStudentAndSelectCourses() {
        student = new Student("1", "小明");
        System.out.println("欢迎" + student.getName() + "选科!");

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入课程ID:");
            String courseID = scanner.next();
            for (Course course : coursesToSelect) {
                if (course.getId().equals(courseID)) {
                    student.getCourses().add(course);
                }
            }
        }
    }

    /**
     * 测试Set的contains方法
     */
    public void testSetContains() {
        System.out.println("请输入学生已选的课程名称:");
        Course course2 = new Course();
        course2.setName(scanner.next());
        System.out.println("创建新课程:" + course2.getName());
        System.out.println("备选课程中是否包含课程:" + course2.getName()
                                   + "," + student.getCourses().contains(course2));
    }

    public void testForEachForSet(Student student) {
        for (Course course : student.getCourses()) {
            System.out.println("选择了课程:" + course.getId() + ":" + course.getName());
        }
    }

    /**
     * 用于往coursesToSelect中添加课程
     */
    public void testAdd() {
        Course course1 = new Course("1", "数据结构");
        coursesToSelect.add(course1);
//        Course temp = coursesToSelect.get(0);
//        System.out.println("添加了课程:" + temp.getId() + ":" + temp.getName());

        Course course2 = new Course("2", "C语言");
        coursesToSelect.add(course2);
//        Course temp2 = coursesToSelect.get(0);
//        System.out.println("添加了课程:" + temp2.getId() + ":" + temp2.getName());

        Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        coursesToSelect.addAll(Arrays.asList(courses));
//        Course temp3 = coursesToSelect.get(2);
//        Course temp4 = coursesToSelect.get(3);
//        System.out.println("添加了两门课程:" + temp3.getId() + ":" + temp3.getName() + ";"
//                                   + temp4.getId() + ":" + temp4.getName());

        Course[] courses2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
        coursesToSelect.addAll(Arrays.asList(courses2));
//        Course temp5 = coursesToSelect.get(2);
//        Course temp6 = coursesToSelect.get(3);
//        System.out.println("添加了两门课程:" + temp5.getId() + ":" + temp5.getName() + ";"
//                                   + temp6.getId() + ":" + temp6.getName());
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
     * 测试list的contains方法
     */
    public void testListContains() {
//        Course course = coursesToSelect.get(0);
//        System.out.println("取得课程:" + course.getName());
//        System.out.println("备选课程中是否包含课程:" + course.getName()
//                                   + "," + coursesToSelect.contains(course));
//        Course course1 = new Course(course.getId(), course.getName());
        System.out.println("输入要查找的课程名称:");
        Course course2 = new Course();
        course2.setName(scanner.next());
        System.out.println("创建新课程:" + course2.getName());
        System.out.println("备选课程中是否包含课程:" + course2.getName()
                                   + "," + coursesToSelect.contains(course2));
        if (coursesToSelect.contains(course2)) {
            System.out.println("课程:" + course2.getName() + "的索引位置为:"
                                       + coursesToSelect.indexOf(course2));
        }
    }

}
