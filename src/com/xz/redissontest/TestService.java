package com.xz.redissontest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Package: com.xz.redissontest
 * @ClassName: Service
 * @Author: xz
 * @Date: 2020/4/6 22:05
 * @Version: 1.0
 */
@Service
public class TestService {

    @SentinelResource(value = "common")
    public String common(){
        return "common";
    }
}
