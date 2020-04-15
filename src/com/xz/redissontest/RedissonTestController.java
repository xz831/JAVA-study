package com.xz.redissontest;

import com.alibaba.csp.sentinel.context.ContextUtil;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.xz.redissontest
 * @ClassName: RedissonTestController
 * @Author: xz
 * @Date: 2020/4/6 11:56
 * @Version: 1.0
 */
@RestController
public class RedissonTestController {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private TestService testService;

    @GetMapping("/testa")
    public String test() {
        ContextUtil.enter("testa");
        testService.common();
        return "testa";
    }

    @GetMapping(value = "/testb")
    public String testb() {
        ContextUtil.enter("testb");
        testService.common();
        return "testb";
    }
}
