package com.javaExercise.io;

import java.io.*;

/**
 * Created by yuanyin on 16/1/28.
 */
public class ObjectSeriaDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化递归调用父类的构造函数
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("demo/obj1.dat"));
//        Foo2 foo2=new Foo2();
//        oos.writeObject(foo2);
//        oos.flush();
//        oos.close();
//
//        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("demo/obj1.dat"));
//        Foo2 foo21= (Foo2) ois.readObject();
//        ois.close();

        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("demo/obj1.dat"));
        Bar2 bar2 = new Bar2();
        oos1.writeObject(bar2);
        oos1.flush();
        oos1.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("demo/obj1.dat"));
        Bar2 bar21 = (Bar2) ois.readObject();
        ois.close();

        /**
         * 对子类对象进行反序列化操作,
         * 如果其父类没有实现序列化接口,
         * 那么其父类的构造函数会被调用
         *
         * 如果其父类实现了序列化接口,
         * 那么其父类飞构造函数不会被调用.
         * 因为可以直接从文件中读取到该类,不需要先构造其父类
         */
    }
}

/**
 * 一个类实现了序列化接口,其子类都可以进行序列化
 */
class Foo implements Serializable {
    public Foo() {
        System.out.println("foo...");
    }
}

class Foo1 extends Foo {
    public Foo1() {
        System.out.println("foo1...");
    }
}

class Foo2 extends Foo {
    public Foo2() {
        System.out.println("foo2...");
    }
}

class Bar {
    public Bar() {
        System.out.println("bar...");
    }
}

class Bar1 extends Bar implements Serializable {
    public Bar1() {
        System.out.println("bar1...");
    }
}

class Bar2 extends Bar1 {
    public Bar2() {
        System.out.println("bar2...");
    }
}