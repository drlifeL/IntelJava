package com.study.io;

import java.io.File;

/**
 * 名称或路径
 * getName()
 * getPath() 构建的时候是使用绝对路径返回绝对路径，否则返回相对
 * getAbsolutePath()
 * getParent()
 */
public class FileDemo03 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\Message.txt";

        File src = new File("filePath");

        System.out.println("文件名：" + src.getName());

        System.out.println("文件路径（相对）" + src.getPath());

        System.out.println("文件路径(绝对)" + src.getAbsolutePath());

        System.out.println("获取父路径" + src.getParent());

    }
}
