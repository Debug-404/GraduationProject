package com.annotation.aspect;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.annotation.RequestLog)")
    public void logAspect() {
    }

    /**
     * AOP日志管理
     *
     * @param joinPoint
     */
    @Before("logAspect()")
    public void beforePkhLog(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String methodName = joinPoint.getSignature().getName();
        log.info("========================================= Method " + methodName + "() begin=========================================");
        // 执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String time = sdf.format(d);
        log.info("Time           : " + time);
        // 打印请求 URL
        log.info("URL :            " + request.getRequestURL());
        // 打印 请求方法
        log.info("HTTP Method:     " + request.getMethod());
        // 打印controller 的全路径以及执行方法
        log.info("Class Method   : " + joinPoint.getSignature().getDeclaringTypeName() + "." + methodName);
        // 打印请求的 IP
        log.info("IP             : " + request.getRemoteHost());
        // 打印请求入参
        //System.out.println("Request Args   : " + JSON.toJSONString(joinPoint.getArgs()));
        Object[] args = joinPoint.getArgs();
        if (Objects.nonNull(args)) {
            List<Object> argsList = Arrays.asList(args);
            // 将 HttpServletResponse 和 HttpServletRequest 参数移除，不然会报异常
            List<Object> collect = argsList.stream()
                    .filter(o -> !(o instanceof HttpServletResponse || o instanceof HttpServletRequest || o instanceof HttpSession))
                    .collect(Collectors.toList());
            args = collect.toArray(args);
        }
        log.info("Request Args   : " + JSON.toJSONString(args));
        log.info("=======================================================================================================");
    }

    @After("logAspect()")
    public void afterPkhLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("========================================= Method " + methodName + "() end =========================================");
    }
}
