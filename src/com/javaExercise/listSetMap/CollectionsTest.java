package com.javaExercise.listSetMap;

import java.util.*;

/**
 * Created by yuanyin on 16/1/3.
 * 1.通过Collections.sort()方法,对Integer泛型的list进行排序;
 * 2.对String泛型的list进行排序;
 * 3.对其他类型泛型的list进行排序,以Student为例.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        CollectionsTest collectionsTest = new CollectionsTest();
//        collectionsTest.testSort1();
//        collectionsTest.testSort2();
        collectionsTest.testSort3();
    }

    /**
     * 1.过Collections.sort()方法,对Integer泛型的list进行排序;
     * 创建一个Integer泛型的list,插入十个100以内的不重复随机整数,
     * 调用Collections.sort()方法对其进行排序
     */
    public void testSort1() {
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            Integer k;
            do {
                k = (int) (Math.random() * 100);
            } while (integerList.contains(k));
            integerList.add(k);
            System.out.println("成功添加整数:" + k);
        }
        System.out.println("------------排序前-----------");
        for (Integer integer : integerList) {
            System.out.print(integer + " ");
        }
        System.out.print("\n");
        Collections.sort(integerList);
        System.out.println("------------排序后-----------");
        for (Integer integer : integerList) {
            System.out.print(integer + " ");
        }
        System.out.print("\n");
    }

    /**
     * 2.对String泛型的list进行排序;
     * 创建String泛型的list,添加三个乱序的String元素,
     * 调用sort方法,再次输出排序后的顺序
     * <p/>
     * 增强版:
     * 1.创建完list<String>之后,往其中添加十条随机字符串
     * 2.每条字符串的长度为10以内的随机数
     * 3.每条字符串的每个字符都是随机生成的字符,字符可以重复
     * 4.每条随机字符串不可重复
     */
    public void testSort2() {
        List<String> stringList = new ArrayList<String>();
//        stringList.add("microsoft");
//        stringList.add("google");
//        stringList.add("lenovo");

        Random random = new Random();
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 10; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            do {
                int length = random.nextInt(10);
                for (int j = 0; j < length; j++) {
                    stringBuilder.append(base.charAt(random.nextInt(base.length())));
                }
            } while (stringList.contains(stringBuilder.toString()));
            stringList.add(stringBuilder.toString());
            System.out.println("成功添加字符串:" + stringBuilder.toString());
        }

        System.out.println("------------排序前-----------");
        for (String str : stringList) {
            System.out.println("元素:" + str);
        }
        Collections.sort(stringList);
        System.out.println("------------排序后-----------");
        for (String str : stringList) {
            System.out.println("元素:" + str);
        }
    }

    /**
     * 3.对其他类型泛型的list进行排序,以Student为例.
     * 生成3个不重复的1000以内的随机正整数作为学生ID
     */
    public void testSort3() {
        List<Student> studentList = new ArrayList<Student>();
        String[] nameList = {"zhangsan", "lisi", "wangwu"};
        List<Integer> idList = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            Integer k;
            do {
                k = new Random().nextInt(999) + 1;
            } while (idList.contains(k));
            idList.add(k);
            Student newStudent = new Student(k + "", nameList[i]);
            studentList.add(newStudent);
            System.out.println("成功添加学生:" + newStudent.getId() + ":" + newStudent.getName());
        }

        studentList.add(new Student(10000 + "", "lllll"));

        System.out.println("------------排序前-----------");
        for (Student student : studentList) {
            System.out.println("学生:" + student.getId() + ":" + student.getName());
        }
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId()));
            }
        });
        System.out.println("------------排序后-----------");
        for (Student student : studentList) {
            System.out.println("学生:" + student.getId() + ":" + student.getName());
        }
    }
}
