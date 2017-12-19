package com.doctorwork.union.common.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by barry on 2017/9/29.
 */
@Aspect
@Component
@Slf4j
public class AspectRequest {

    private Gson gson=new Gson();

    @Pointcut("execution(public * com.doctorwork.union.module..*Controller.*(..))")
    private void controllerAspect(){}


    @Pointcut("execution( * com.doctorwork.union.module..*Impl.*(..))")
    private void serviceAspect(){}


    //请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //MDC.put("traceid",  System.currentTimeMillis()+"");
        //打印请求内容
        log.info("url: {} {}",request.getMethod(),request.getRequestURL().toString());
        log.info("method: {} start {} param:{}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(Arrays.toString(joinPoint.getArgs())));
    }
    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o",pointcut = "controllerAspect()")
    public void methodAfterReturing(JoinPoint joinPoint,Object o ){
        log.info("method: {} end {} Res: {}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(o));
        MDC.remove("traceid");
    }


    @Before(value = "serviceAspect()")
    public void serviceMethodBefore(JoinPoint joinPoint){
        log.info("method: {} start {} param:{}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(returning = "o",pointcut = "serviceAspect()")
    public void serviceMethodAfter(JoinPoint joinPoint,Object o){
        log.info("method: {} end {} Res: {}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(o));

    }



}
