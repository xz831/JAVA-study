package com.xz.aspect;

import org.springframework.stereotype.Component;

/**
 * @Package: com.xz.aspect
 * @ClassName: SimpleMethod
 * @Author: xz
 * @Date: 2020/4/17 20:32
 * @Version: 1.0
 */
@Component
public class SimpleMethod {

    @Plus
    public void test(){
        System.out.println("执行方法");
    }
}
