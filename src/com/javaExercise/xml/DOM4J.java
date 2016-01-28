package com.javaExercise.xml;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * DOM4J方式解析XML文件
 * <p/>
 * Created by yuanyin on 16/1/28.
 */
public class DOM4J {
    public static void main(String[] args) {
//        dom4jXMLParser();
        createXML();
    }

    public static void createXML() {
        Document document = DocumentHelper.createDocument();
        Element rss = document.addElement("rss");
        rss.addAttribute("version", "2.0");
        Element channel = rss.addElement("channel");
        Element title = channel.addElement("title");
        title.setText("<{国内最新新闻}>");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(new File("demo/rssnews.xml")), format);
            writer.setEscapeText(false);
            writer.write(document);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dom4jXMLParser() {
        SAXReader reader = new SAXReader();
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        try {
            Document document = reader.read("demo/books.xml");
            Element bookstore = document.getRootElement();
            Iterator iterator = bookstore.elementIterator();
            int bookIndex = 0;
            while (iterator.hasNext()) {
                Book bookEntity = new Book();
                bookIndex++;
                System.out.println("=======开始解析第" + bookIndex + "本书的内容=======");
                Element book = (Element) iterator.next();

                List<Attribute> bookAttrs = book.attributes();
                for (Attribute bookAttr : bookAttrs) {
                    System.out.println("第" + (bookAttrs.indexOf(bookAttr) + 1) + "个属性名:" + bookAttr.getName()
                                               + "---属性值:" + bookAttr.getValue());
                    if (bookAttr.getName().equals("id")) {
                        bookEntity.setId(bookAttr.getValue());
                    }
                }

                Iterator childIterator = book.elementIterator();
                int childIndex = 0;
                while (childIterator.hasNext()) {
                    childIndex++;
                    Element bookChild = (Element) childIterator.next();
                    String childName = bookChild.getName();
                    String childValue = bookChild.getStringValue();
                    System.out.println("第" + childIndex + "个子节点名称:" + childName + "---节点值:" + childValue);
                    if (childName.equals("name")) {
                        bookEntity.setName(childValue);
                    } else if (childName.equals("author")) {
                        bookEntity.setAuthor(childValue);
                    } else if (childName.equals("year")) {
                        bookEntity.setYear(childValue);
                    } else if (childName.equals("price")) {
                        bookEntity.setPrice(childValue);
                    } else if (childName.equals("language")) {
                        bookEntity.setLanguage(childValue);
                    }
                }
                bookArrayList.add(bookEntity);

                System.out.println("=======结束解析第" + bookIndex + "本书的内容=======");
            }
            System.out.println(bookArrayList);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
