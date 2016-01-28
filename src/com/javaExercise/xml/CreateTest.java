package com.javaExercise.xml;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuanyin on 16/1/28.
 */
public class CreateTest {

    @Test
    public void testMain() throws Exception {

        System.out.println("性能测试");
        long start = System.currentTimeMillis();
        DOMTest.createXML();
        System.out.println("DOM:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        SAXTest.createXML();
        System.out.println("SAX:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        JDOMTest.createXML();
        System.out.println("JDOM:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        DOM4J.createXML();
        System.out.println("DOM4J:" + (System.currentTimeMillis() - start));
    }

}