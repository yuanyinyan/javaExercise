package com.javaExercise.listSetMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yuanyin on 16/1/2.
 * 添加学生的类
 * 学习HashMap相关操作
 */
public class MapTest {

    private Map<String, Student> students;//用于承装学生类型对象

    public MapTest() {
        this.students = new HashMap<String, Student>();
    }

    public static void main(String[] args) {
        MapTest maptest = new MapTest();
        maptest.testPut();
        maptest.testKeySet();
//        maptest.testRemove();
//        maptest.testModify();
//        maptest.testEntrySet();
        maptest.testContainsKeyOrValue();
    }

    /**
     * 测试添加:输入学生Id,判断是否被占用
     * 若未被占用,则输入姓名,创建新学生对象,并添加到students中
     */
    public void testPut() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入学生ID:");
            String studentID = scanner.next();
            Student student = students.get(studentID);
            if (student == null) {
                System.out.println("请输入学生姓名:");
                String name = scanner.next();
                Student newStudent = new Student(studentID, name);
                students.put(studentID, newStudent);
                System.out.println("成功添加学生:" + students.get(studentID).getName());
            } else {
                System.out.println("该学生ID被占用!");
                i--;
            }
        }
    }

    /**
     * 测试Map的KeySet方法
     */
    public void testKeySet() {
        Set<String> keySet = students.keySet();
        System.out.println("总共有:" + students.size() + "个学生!");
        for (String id : keySet) {
            Student student = students.get(id);
            if (student != null) {
                System.out.println("学生:" + student.getName());
            }
        }
    }

    /**
     * 通过entrySet遍历Map
     */
    public void testEntrySet() {
        Set<Map.Entry<String, Student>> entrySet = students.entrySet();
        for (Map.Entry<String, Student> entry : entrySet) {
            System.out.println("取得键:" + entry.getKey());
            System.out.println("对应的值为:" + entry.getValue().getName());
        }
    }

    /**
     * 测试删除Map中的映射
     */
    public void testRemove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要删除的学生ID:");
            String ID = scanner.next();
            Student student = students.get(ID);
            if (student == null) {
                System.out.println("输入的学生ID不存在!");
            } else {
                students.remove(ID);
                System.out.println("成功删除学生:" + student.getName());
                break;
            }
        }
    }

    /**
     * 通过put修改Map中已有的键值对
     */
    public void testModify() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要修改的学生ID:");
            String ID = scanner.next();
            Student student = students.get(ID);
            if (student == null) {
                System.out.println("输入的学生ID不存在!");
            } else {
                System.out.println("当前该ID对应的学生为:" + student.getName());
                System.out.println("请输入新的学生姓名:");
                String name = scanner.next();
                Student newStudent = new Student(ID, name);
                students.put(ID, newStudent);
                System.out.println("成功修改学生为:" + ID + ":" + students.get(ID).getName());
                break;
            }
        }
    }

    /**
     * 测试Map中,是否包含某key或者某value值
     */
    public void testContainsKeyOrValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的学生ID:");
        String ID = scanner.next();
        System.out.println("您输入的学生ID为:" + ID + ",在学生映射表中是否存在:"
                                   + students.containsKey(ID));
        if (students.containsKey(ID)) {
            System.out.println("对应的学生为:" + students.get(ID).getName());
        }
        System.out.println("请输入要查询的学生姓名:");
        String name = scanner.next();
        Student student = new Student(null, name);
        System.out.println("您输入的学生姓名为:" + name + ",在学生映射表中是否存在:"
                                   + students.containsValue(student));
    }
}
