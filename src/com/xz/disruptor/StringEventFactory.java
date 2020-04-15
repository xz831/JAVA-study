package com.xz.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Package: com.xz.disruptor
 * @ClassName: LongEventFactory
 * @Author: xz
 * @Date: 2020/4/5 15:23
 * @Version: 1.0
 */
public class StringEventFactory implements EventFactory<StringEvent> {
    public StringEvent newInstance() {
        return new StringEvent();
    }
}
