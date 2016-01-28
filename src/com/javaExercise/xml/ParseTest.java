package com.javaExercise.xml;

import org.junit.Test;

/**
 * 测试DOM,SAX,JDOM,DOM4J四种方式解析XML文件的效率
 * <p/>
 * Created by yuanyin on 16/1/28.
 */
public class ParseTest {

    @Test
    public void testMain() throws Exception {
        System.out.println("性能测试");
        long start = System.currentTimeMillis();
        DOMTest.domXMlParser();
        System.out.println("DOM:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        SAXTest.saxXMLParser();
        System.out.println("SAX:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        JDOMTest.jdomXMLParser();
        System.out.println("JDOM:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        DOM4J.dom4jXMLParser();
        System.out.println("DOM4J:" + (System.currentTimeMillis() - start));
    }

}