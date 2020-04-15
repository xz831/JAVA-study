package com.xz.hutool;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.bloomfilter.BloomFilterUtil;
import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.swing.RobotUtil;
import com.xz.proxy.Animal;
import com.xz.proxy.Cat;
import com.xz.redissontest.TestService;

import javax.crypto.interfaces.PBEKey;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz
 * @ClassName: HuToolDemo
 * @Author: xz
 * @Date: 2020/4/9 18:16
 * @Version: 1.0
 */
public class HuToolDemo {

    public static void main(String[] args) throws InterruptedException {
        //代理
//        Animal proxy = ProxyUtil.proxy(new Cat(), AOP.class);
//        proxy.eat();
        //布隆过滤
//        BitMapBloomFilter bitMap = BloomFilterUtil.createBitMap(1024);
//        bitMap.add("123");
//        bitMap.add("12323");
//        bitMap.add("213124");
//        System.out.println(bitMap.contains("123"));
        //缓存
//        FIFOCache<Object, Object> objects = CacheUtil.newFIFOCache(1, 2000);
//        objects.put("123","1234");
//        objects.put("1234","1234");
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(objects.get("123"));
//        new AOP().test();
//        System.out.println(NetUtil.getLocalMacAddress());
        for(int i=1;i<1000;i++){
//            TimeUnit.MILLISECONDS.sleep(1);
            RobotUtil.mouseMove(i,i);
        }
    }
}
class AOP extends SimpleAspect{
    @Override
    public boolean before(Object target, Method method, Object[] args) {
        System.out.println("你妹");
        return super.before(target, method, args);
    }

    public void test(){
        System.out.println(CallerUtil.getCaller());
    }
}