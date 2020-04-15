package com.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Package: com.xz
 * @ClassName: Application
 * @Author: xz
 * @Date: 2020/4/6 12:13
 * @Version: 1.0
 */
@SpringCloudApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
