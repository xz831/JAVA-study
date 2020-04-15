package com.xz.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @Package: com.xz.disruptor
 * @ClassName: StringTest
 * @Author: xz
 * @Date: 2020/4/5 15:35
 * @Version: 1.0
 */
public class StringTest {
    public static void main(String[] args) {
//        StringEventFactory factory = new StringEventFactory();
        int size = 1<<10;
//        Disruptor<StringEvent> disruptor = new Disruptor<>(factory,size, Executors.defaultThreadFactory());
        Disruptor<StringEvent> disruptor = new Disruptor<>(StringEvent::new,size, DaemonThreadFactory.INSTANCE);
//        disruptor.handleEventsWith(new StringEventHandler());
        EventHandler<StringEvent> eventHandler = (e, l, b) -> {
            System.out.println(e + " " + l + " " + b);
            if("exception".equals(e.getEvent())){
                throw new Exception();
            }
        };
        disruptor.handleEventsWith(eventHandler);
        disruptor.handleExceptionsFor(eventHandler).with(new ExceptionHandler<StringEvent>() {
            @Override
            public void handleEventException(Throwable ex, long sequence, StringEvent event) {
                System.out.println(event);
                ex.printStackTrace();
            }

            @Override
            public void handleOnStartException(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void handleOnShutdownException(Throwable ex) {
                ex.printStackTrace();
            }
        });
        disruptor.start();
        RingBuffer<StringEvent> ringBuffer = disruptor.getRingBuffer();
//        long next = ringBuffer.next();
//        try {
//            StringEvent stringEvent = ringBuffer.get(next);
//            stringEvent.setEvent("hello world");
//        }finally {
//            ringBuffer.publish(next);
//        }
        ringBuffer.publishEvent((e,s)->e.setEvent("hello"));
        ringBuffer.publishEvent((e,s,a)->e.setEvent(a),"exception");
        ringBuffer.publishEvent((e,s,a)->e.setEvent(a),"world");
    }
}
