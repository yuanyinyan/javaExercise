package com.javaExercise.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL常用方法
 *
 * Created by yuanyin on 16/1/29.
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            URL imooc=new URL("http://www.imooc.com");
            //?后面表示参数,#后面表示锚点
            URL url=new URL(imooc,"/index.html?username=tom#test");
            System.out.println("协议:"+url.getProtocol());
            System.out.println("主机:"+url.getHost());
            //如果未指定端口号,则使用默认端口号,此时getPort()方法返回值为-1
            System.out.println("端口号:"+url.getPort());
            System.out.println("文件路径:"+url.getPath());
            System.out.println("文件名:"+url.getFile());
            System.out.println("相对路径:"+url.getRef());
            System.out.println("查询字符串:"+url.getQuery());
            System.out.println();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //使用URL读取页面内容
        try {
            URL url=new URL("http://www.baidu.com");
            InputStream is=url.openStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String data;
            if((data=br.readLine())!=null){
                System.out.println(data);
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
