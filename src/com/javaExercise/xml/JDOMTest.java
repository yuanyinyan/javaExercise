package com.javaExercise.xml;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDOM方式解析XML文件
 * <p/>
 * Created by yuanyin on 16/1/28.
 */
public class JDOMTest {

    public static void main(String[] args) {
//        jdomXMLParser();
        createXML();
    }

    public static void createXML() {
        Element rss = new Element("rss");
        rss.setAttribute("version", "2.0");
        Document document = new Document(rss);

        Element channel = new Element("channel");
        rss.addContent(channel);
        Element title = new Element("title");
        title.addContent(new CDATA("国内最新新闻"));
        channel.addContent(title);

        Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");

        XMLOutputter outputter = new XMLOutputter(format);
        try {
            outputter.output(document, new FileOutputStream(new File("demo/rssnews1.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jdomXMLParser() {
        SAXBuilder saxBuilder = new SAXBuilder();
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        try {
            //用于解决编码问题
//            InputStreamReader isr=new InputStreamReader(new FileInputStream("demo/books.xml"),"UTF-8");
//            Document document = saxBuilder.build(isr);
            Document document = saxBuilder.build("demo/books.xml");
            Element rootElement = document.getRootElement();
            List<Element> bookList = rootElement.getChildren();

            for (Element book : bookList) {
                Book bookEntity = new Book();
                System.out.println("=====开始解析第" + (bookList.indexOf(book) + 1) + "本书=====");

                List<Attribute> attributeList = book.getAttributes();
                for (Attribute attribute : attributeList) {
                    System.out.println("第" + (attributeList.indexOf(attribute) + 1) + "个属性名:" + attribute.getName()
                                               + "---属性值:" + attribute.getValue());
                    if (attribute.getName().equals("id")) {
                        bookEntity.setId(attribute.getValue());
                    }
                }

                List<Element> elementList = book.getChildren();
                for (Element element : elementList) {
                    String childName = element.getName();
                    String childValue = element.getValue();
                    System.out.println("第" + (elementList.indexOf(element) + 1) + "个子节点名称:" + childName
                                               + "---节点值:" + childValue);
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
                System.out.println("=====结束解析第" + (bookList.indexOf(book) + 1) + "本书=====");
            }
            System.out.println(bookArrayList);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
