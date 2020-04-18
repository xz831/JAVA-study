package com.xz.aspect;

import java.lang.annotation.*;

/**
 * @Package: com.xz.aspect
 * @ClassName: Plus
 * @Author: xz
 * @Date: 2020/4/17 20:34
 * @Version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Plus {
}
