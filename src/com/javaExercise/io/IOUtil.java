package com.javaExercise.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yuanyin on 16/1/27.
 */
public class IOUtil {
    /**
     * 读取指定文件内容,按照16进制输出控制台
     * 并且每输出10个byte换行
     * <p/>
     * 单字节读取不适合大文件
     *
     * @param filename
     */
    public static void printHex(String filename) throws IOException {
        //把文件作为字节流进行文件操作
        FileInputStream in = new FileInputStream(filename);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                //单位数前面补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 批量读取适合大文件读取,效率高
     *
     * @param filename
     * @throws IOException
     */
    public static void printHexByByteArray(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        byte[] buf = new byte[8 * 1024];
        /**
         * 从in中批量读取字节,放入到buf字节数组中,
         * 从第0个位置开始放,最多放buf.length个
         * 返回读到字节的个数
         */
//        int bytes = in.read(buf, 0, buf.length);//一次性读完,说明字节数组足够大
//        int j = 1;
//        for (int i = 0; i < bytes; i++) {
//            System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
//            if (j++ % 10 == 0) {
//                System.out.println();
//            }
//        }

        int bytes = 0;
        int j = 1;
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        in.close();
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (srcFile.isDirectory()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();
        }
        in.close();
        out.close();
    }

}
