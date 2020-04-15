package com.xz.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @Package: com.xz.disruptor
 * @ClassName: StringEventHandler
 * @Author: xz
 * @Date: 2020/4/5 15:28
 * @Version: 1.0
 */
public class StringEventHandler implements EventHandler<StringEvent> {

    private static int count = 0;

    public void onEvent(StringEvent stringEvent, long l, boolean b) throws Exception {
        count++;
        System.out.println(count + " " + stringEvent + " " + l + " " + b);
    }
}
