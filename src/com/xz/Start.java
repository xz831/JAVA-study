package com.xz;

import com.xz.aspect.SimpleMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Package: com.xz
 * @ClassName: Start
 * @Author: xz
 * @Date: 2020/4/17 21:06
 * @Version: 1.0
 */
@Component
public class Start implements CommandLineRunner {
    @Autowired
    private SimpleMethod simpleMethod;
    @Override
    public void run(String... args) throws Exception {
        simpleMethod.test();
    }
}
