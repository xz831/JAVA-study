package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: MagicCookie
 * @Author: xz
 * @Date: 2020/4/11 22:28
 * @Version: 1.0
 */
public class MagicCookie extends Food {
    @Override
    void eat() {
        System.out.println("吃魔法饼干");
    }
}
