package com.xz.designPattern.bridge;

/**
 * @Package: com.xz.designPattern.bridge
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/27 20:43
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        BasePhone huaWei = new HuaWei();
        huaWei.setMemory(new Memory8G());
        huaWei.buy();
        BasePhone apple = new Apple();
        apple.setMemory(new Memory6G());
        apple.buy();
    }
}
interface Memory{
    void addMemory();
}
class Memory6G implements Memory{

    @Override
    public void addMemory() {
        System.out.println("安装6G内存");
    }
}
class Memory8G implements Memory{

    @Override
    public void addMemory() {
        System.out.println("安装8G内存");
    }
}
abstract class BasePhone{
    abstract void buy();
    Memory memory;
    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
class HuaWei extends BasePhone{

    @Override
    void buy() {
        memory.addMemory();
        System.out.println("购买华为手机");
    }
}
class Apple extends BasePhone{

    @Override
    void buy() {
        memory.addMemory();
        System.out.println("购买苹果手机");
    }
}
