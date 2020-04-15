package com.xz.disruptor;

/**
 * @Package: com.xz.disruptor
 * @ClassName: LongEvent
 * @Author: xz
 * @Date: 2020/4/5 15:22
 * @Version: 1.0
 */
public class StringEvent {

    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "event='" + event + '\'' +
                '}';
    }
}
