package com.example.springboot.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    public final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.springboot.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("before......");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("**************************************************");
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
        logger.info("**************************************************");
    }

    @After("log()")
    public void deAfter(){
        logger.info("after......");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterRunning(Object object){
        logger.info("response={}",object);
    }
}
