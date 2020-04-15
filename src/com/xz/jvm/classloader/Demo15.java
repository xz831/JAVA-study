package com.xz.jvm.classloader;

import java.io.*;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo15
 * @Author: xz
 * @Date: 2020/2/21 22:04
 * @Version: 1.0
 */
public class Demo15 extends ClassLoader{

    private final String fileExtension = ".class";

    @Override
    protected Class<?> findClass(String name) {
        System.out.println("自定义类加载器执行:"+name);
        byte[] bytes = new byte[0];
        try {
            bytes = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name) throws IOException {
        byte[] data = new byte[1024];
        name = name.replaceAll("\\.","/");
        String s = name + fileExtension;
        File directory = new File("");
        String canonicalPath = directory.getCanonicalPath();
        String s1 = canonicalPath.replaceAll("\\\\", "/")+"/out/production/JVM-study/";
        try (InputStream in = new FileInputStream(new File( s1+ s));
             ByteArrayOutputStream out = new ByteArrayOutputStream()){
            int ch;
            while ((ch=in.read(data)) != -1){
                out.write(data,0,ch);
                out.flush();
            }
            return out.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Demo15 demo15 = new Demo15();
        Class<?> aClass = demo15.findClass("com.xz.jvm.classloader.Demo15");
        Object o = aClass.newInstance();
        System.out.println(o.getClass().getClassLoader());
        demo15 = null;
        aClass = null;
        o = null;
        System.gc();
        demo15 = new Demo15();
        aClass = demo15.findClass("com.xz.jvm.classloader.Demo15");
        o = aClass.newInstance();
        System.out.println(o.getClass().getClassLoader());
    }
}
