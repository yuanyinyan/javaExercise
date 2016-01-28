package com.javaExercise.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by yuanyin on 16/1/28.
 */
public class SAXParserHandler extends DefaultHandler {
    String value = null;
    Book book;
    private ArrayList<Book> bookList=new ArrayList<Book>();
    int bookIndex = 0;

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    //遍历XML文件开始标签
    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        super.startElement(s, s1, s2, attributes);
        if (s2.equals("book")) {
            bookIndex++;
            book = new Book();
            System.out.println("=========================下面开始遍历第" + bookIndex + "本书的内容===========================");

            //已知book元素下属性名称,根据属性名称获取属性
//            String value=attributes.getValue("id");
//            System.out.println("book的属性值是:"+value);

            //不知道属性名称以及个数
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("book元素的第" + (i + 1) + "个属性名是" + attributes.getQName(i) +
                                           "---属性值是:" + attributes.getValue(i));
                if (attributes.getQName(i).equals("id")) {
                    book.setId(attributes.getValue(i));
                }
            }
        } else if (!s2.equals("bookstore")) {
            System.out.print("节点名是:" + s2);
        }
    }

    //遍历XML文件结束标签
    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        super.endElement(s, s1, s2);
        if (s2.equals("book")) {
            bookList.add(book);
            book=null;
            System.out.println("=========================结束遍历第" + bookIndex + "本书的内容===========================");
        } else if (s2.equals("name")) {
            book.setName(value);
        } else if (s2.equals("author")) {
            book.setAuthor(value);
        } else if (s2.equals("year")) {
            book.setYear(value);
        } else if (s2.equals("price")) {
            book.setPrice(value);
        } else if (s2.equals("language")) {
            book.setLanguage(value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().isEmpty()) {
            System.out.println("---节点值是:" + value);
        }
    }

    /**
     * 标示解析开始
     *
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 表示解析结束
     *
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

}
