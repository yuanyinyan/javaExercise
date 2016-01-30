package com.javaExercise.socket;

import java.io.*;
import java.net.Socket;

/**
 * 服务器线程处理类
 * <p/>
 * Created by yuanyin on 16/1/29.
 */
public class ServerThread extends Thread {

    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            //获取输入流,并读取客户信息
            is = socket.getInputStream();//字节输入流
            isr = new InputStreamReader(is);//将字节流转换为字符流
            br = new BufferedReader(isr);//为输入流添加缓冲
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器,客户端说:" + info);
            }
            socket.shutdownInput();

            //获取输出流,响应客户端请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                if (pw != null) pw.close();
                if (os != null) os.close();
                if (br != null) br.close();
                if (isr != null) isr.close();
                if (is != null) is.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
