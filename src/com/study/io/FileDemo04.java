package com.study.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件状态：
 * 1、判断是否存在：exists()
 * 2、判断是文件还是文件夹：
 * isFile()是否是文件
 * isDirectory()//是否是目录
 * length()//文件的大小
 * createNewFile()//创建新文件
 *
 *
 */
public class FileDemo04 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/Administrator/Desktop/a.txt";

        File src = new File(filePath);

        System.out.println("是否存在" + src.exists());
        if(!src.exists()){
            //创建新的文件
            src.createNewFile();

        }
        System.out.println("是否是文件:" + src.isFile());

        System.out.println("是否是目录:" + src.isDirectory());

        System.out.println("大小："+src.length());

        char []a  = new char[5];
        System.out.println(a.length);

    }
}
