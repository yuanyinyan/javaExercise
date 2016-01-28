package com.javaExercise.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * SAX方式解析XML文件
 * <p/>
 * Created by yuanyin on 16/1/28.
 */
public class SAXTest {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser parser = spf.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            parser.parse("demo/books.xml", handler);
            System.out.println("共有"+handler.getBookList().size()+"本书");
            System.out.println(handler.getBookList());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
