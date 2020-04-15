package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo17
 * @Author: xz
 * @Date: 2020/2/22 17:54
 * @Version: 1.0
 */
public class Demo16 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Demo15 demo15 = new Demo15();
        Class<?> aClass = demo15.findClass("com.xz.jvm.classloader.MySample");
        System.out.println(aClass.hashCode());
        //如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        //因此不会实例化MyCat对象，即没有对MyCat主动使用，这里就不会加载MyCat Class
//        Object o = aClass.newInstance();
    }
}
