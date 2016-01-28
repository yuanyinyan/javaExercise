package com.javaExercise.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * SAX方式解析XML文件
 * <p/>
 * Created by yuanyin on 16/1/28.
 */
public class SAXTest {
    public static void main(String[] args) {
//        saxXMLParser();
        createXML();
    }

    public static void createXML() {
        ArrayList<Book> bookArrayList = saxXMLParser();
        SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            TransformerHandler handler = tff.newTransformerHandler();
            Transformer transformer = handler.getTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            Result result = new StreamResult(new FileOutputStream(new File("demo/book2.xml")));
            handler.setResult(result);
            handler.startDocument();
            AttributesImpl attributes = new AttributesImpl();
            handler.startElement("", "", "bookstore", attributes);

            for (Book book : bookArrayList) {
                attributes.clear();
                attributes.addAttribute("", "", "id", "", book.getId());
                handler.startElement("", "", "book", attributes);
                if (book.getName() != null && !book.getName().trim().isEmpty()) {
                    attributes.clear();
                    handler.startElement("", "", "name", attributes);
                    handler.characters(book.getName().toCharArray(), 0, book.getName().length());
                    handler.endElement("", "", "name");
                }
                if (book.getYear() != null && !book.getYear().trim().isEmpty()) {
                    attributes.clear();
                    handler.startElement("", "", "year", attributes);
                    handler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
                    handler.endElement("", "", "year");
                }
                if (book.getAuthor() != null && !book.getAuthor().trim().isEmpty()) {
                    attributes.clear();
                    handler.startElement("", "", "author", attributes);
                    handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
                    handler.endElement("", "", "author");
                }
                if (book.getPrice() != null && !book.getPrice().trim().isEmpty()) {
                    attributes.clear();
                    handler.startElement("", "", "price", attributes);
                    handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
                    handler.endElement("", "", "price");
                }
                if (book.getLanguage() != null && !book.getLanguage().trim().isEmpty()) {
                    attributes.clear();
                    handler.startElement("", "", "language", attributes);
                    handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
                    handler.endElement("", "", "language");
                }
                handler.endElement("", "", "book");
            }
            handler.endElement("", "", "bookstore");
            handler.endDocument();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> saxXMLParser() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParserHandler handler = new SAXParserHandler();
        try {
            SAXParser parser = spf.newSAXParser();
            parser.parse("demo/books.xml", handler);
            System.out.println("共有" + handler.getBookList().size() + "本书");
            System.out.println(handler.getBookList());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handler.getBookList();
    }

}
