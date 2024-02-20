package com.ezswap.configuration;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jiang.guangjin
 * @date 2020/12/14
 * @email 122***5417@qq.com
 * @mobile 183****1631
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    //用来记录请求进入的时间，防止多线程时出错，这里用了ThreadLocal
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    HttpServletRequest request;

    /**
     * 定义切入点，controller下面的所有类的所有公有方法，这里需要更改成自己项目的
     */
    @Pointcut("execution(public * com.ezswap.controller..*(..))")
    public void requestLog() {
    }

    /**
     * 方法之前执行，日志打印请求信息
     *
     * @param joinPoint joinPoint
     */
    @Before("requestLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        //打印请求参数，如果需要打印其他的信息可以到request中去拿
//        log.debug("RequestParam:{}", Arrays.toString(joinPoint.getArgs()));


    }

    /**
     * 方法返回之前执行，打印才返回值以及方法消耗时间
     *
     * @param response 返回值
     */
    @AfterReturning(returning = "response", pointcut = "requestLog()")
    public void doAfterRunning(JoinPoint joinPoint, Object response) {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        request = servletRequestAttributes.getRequest();
        Long currentTime = System.currentTimeMillis();
        //打印当前的请求路径
        Integer handlerTime = Math.toIntExact(currentTime - startTime.get());
        //打印返回值信息
        log.info(request.getRequestURI() + "\t" + new Gson().toJson(joinPoint.getArgs()) + "\t"+ new Gson().toJson(response) + "\t" + handlerTime);
    }
}
