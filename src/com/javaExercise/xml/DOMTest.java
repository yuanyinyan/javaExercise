package com.javaExercise.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * DOM方式解析XML文件
 * <p/>
 * Created by yuanyin on 16/1/28.
 */
public class DOMTest {

    public static void main(String[] args) {
        domXMlParser();
    }

    public static void domXMlParser() {

        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("demo/books.xml");
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有" + bookList.getLength() + "本书.");

            for (int i = 0; i < bookList.getLength(); i++) {
                Book bookEntity = new Book();
                System.out.println("=========================下面开始遍历第" + (i + 1) + "本书的内容===========================");
                Node book = bookList.item(i);

                //未知属性名时的属性遍历
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性.");
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.println("属性名:" + attr.getNodeName() + "--属性值" + attr.getNodeValue());
                    if (attr.getNodeName().equals("id")) {
                        bookEntity.setId(attr.getNodeValue());
                    }
                }

                //已知属性名时的属性遍历
//                Element book0=(Element) bookList.item(i);
//                book0.getAttribute("id");

                NodeList childNodes = book.getChildNodes();
                System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点");
                for (int k = 0; k < childNodes.getLength(); k++) {
                    Node childNode = childNodes.item(k);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        String childName = childNode.getNodeName();
                        String childValue = childNode.getTextContent();
                        System.out.println("第" + (k + 1) + "个节点的节点名:" + childName +
                                                   "--节点值是:" + childValue);
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
                }
                bookArrayList.add(bookEntity);

                System.out.println("=========================结束遍历第" + (i + 1) + "本书的内容===========================");
            }
            System.out.println(bookArrayList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
