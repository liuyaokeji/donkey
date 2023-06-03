package com.donkey.aspect;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 日志打印切面
 *
 * @author liuyao
 */
@Aspect
@Component
@Slf4j
public class ServiceLogAspect {
    /**
     * 切入点是控制器
     */
    @Pointcut("execution(public * com..controller.*Controller.*(..))")
    public void log() {
    }

    /**
     * 方法执行前、后
     *
     * @param point 切入信息
     * @return 返回值
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        // 取请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        long startTime = System.currentTimeMillis();
        //获取请求头部
        Enumeration<String> enumeration = request.getHeaderNames();
        Map<String, String> headerMap = new HashMap<>(16);
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                headerMap.put(key, request.getHeader(key));
            }
        }
        String body = "{}";
        if (point.getArgs() != null && point.getArgs().length > 0) {
            body= JSON.toJSONString(point.getArgs()[0]);
        }


        // 准备日志信息
        StringBuilder sb = new StringBuilder();
        sb.append("\n【request_id】:").append(MDC.get("requestId"));
        sb.append("\n【请求 URL】:").append(request.getRequestURL());
        sb.append("\n【请求 IP】:").append(request.getRemoteAddr());
        sb.append("\n【请求Header】:").append(headerMap);
        sb.append("\n【请求参数】:").append(body);
        sb.append("\n【请求方式】:").append(request.getMethod());
        sb.append("\n【请求类名】:").append(point.getSignature().getDeclaringTypeName());
        sb.append("\n【请求方法名】:").append(point.getSignature().getName());
        Object result;
        // 继续执行方法，得到返回值
        result = point.proceed();
        sb.append("\n【返回值】:").append(JSON.toJSONString(result));
        sb.append("\n【执行时间】:").append(System.currentTimeMillis() - startTime+"ms");
        log.info(sb.toString());
        return result;
    }
}
