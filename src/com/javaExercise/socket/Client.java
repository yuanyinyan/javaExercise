package com.javaExercise.socket;

import java.io.*;
import java.net.Socket;

/**
 * 基于TCP协议的socket通信,实现用户登录
 * 客户端
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名:admin;密码:123");
            pw.flush();
            socket.shutdownOutput();

            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端,服务器说:" + info);
            }

            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
