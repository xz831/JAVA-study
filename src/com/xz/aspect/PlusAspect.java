package com.xz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Package: com.xz.aspect
 * @ClassName: PlusAspect
 * @Author: xz
 * @Date: 2020/4/17 21:02
 * @Version: 1.0
 */
@Aspect
@Component
public class PlusAspect {

    @Pointcut("@annotation(com.xz.aspect.Plus)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object aspectHandler(ProceedingJoinPoint point) throws Throwable {
        System.out.println("前处理");
        Object proceed = point.proceed();
        System.out.println("后处理");
        return proceed;
    }
}
