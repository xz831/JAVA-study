package com.xz.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Package: com.xz.files
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/22 17:37
 * @Version: 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        String path = "D://迅雷下载/哆啦A梦.jpg";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(path));
            File file = new File("D://迅雷下载/哆啦A梦"+0+".jpg");
            Files.copy(fileInputStream,file.toPath());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
