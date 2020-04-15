package com.xz.jvm.classloader;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo20
 * @Author: xz
 * @Date: 2020/2/25 13:56
 * @Version: 1.0
 */
public class Demo20 {
    /**
     * Reflection.getCallerClass() api without @CallerSensitive
     * When Class is loaded by App/Ext/Bootstrap ClassLoader then java.lang.InternalError: CallerSensitive annotation expected at frame 1
     */
    private static void getCallerClassWithoutCallerSensitive() {
        try {
            System.out.format("Method is called by %s%n", Reflection.getCallerClass());
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reflection.getCallerClass() api with @CallerSensitive
     * When Class is loaded by AppClassLoader then java.lang.InternalError: CallerSensitive annotation expected at frame 1
     * When Class is loaded by ExtClassLoader/BootstrapClassLoader, then works fine.
     */
    @CallerSensitive
    private static void getCallerClassWithCallerSensitive() {
        try {
            System.out.format("Method is called by %s%n", Reflection.getCallerClass());
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deprecated Reflection.getCallerClass(n) api
     */
    private static void getCallerClassN() {
        int i = 0;
        while (Reflection.getCallerClass(i) != null) {
            System.out.println(Reflection.getCallerClass(i++));
        }
    }

    /**
     * Iterate Throwable getStackTrace
     */
    private static void getCallerClassByStackTrace() {
        StackTraceElement[] stackTraces = new Throwable().getStackTrace();
        Arrays.stream(stackTraces).forEach(e -> System.out.println(e.getClassName() + " " + e.getMethodName()));
    }

    private static void invoke(String methodName) throws Exception {
        //direct call
        System.out.format("Enter direct call %s%n", methodName);
        switch (methodName) {
            case "getCallerClassWithoutCallerSensitive":
                getCallerClassWithoutCallerSensitive();
                break;
            case "getCallerClassWithCallerSensitive":
                getCallerClassWithCallerSensitive();
                break;
            case "getCallerClassN":
                getCallerClassN();
                break;
            case "getCallerClassByStackTrace":
                getCallerClassByStackTrace();
                break;
            default:
                break;
        }
        System.out.format("Exit direct call %s%n%n", methodName);

        //reflection call
        System.out.format("Enter reflection call %s%n", methodName);
        Method method = Demo20.class.getDeclaredMethod(methodName);
        method.invoke(null);
        System.out.format("Exit reflection call %s%n%n", methodName);
    }

    public static void main(String[] args) throws Exception {
        System.out.format("Main class loaded by %s%n%n", Demo20.class.getClassLoader());

//        invoke("getCallerClassWithoutCallerSensitive");
//        System.out.println("-------");
        invoke("getCallerClassWithCallerSensitive");
//        System.out.println("-------");
//        invoke("getCallerClassN");
//        System.out.println("-------");
//        invoke("getCallerClassByStackTrace");
    }
}