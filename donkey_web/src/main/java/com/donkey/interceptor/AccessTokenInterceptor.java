package com.donkey.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static com.donkey.constant.Constants.REQUEST_ID;
import static com.donkey.constant.Constants.REQUEST_URI;

/**
 * 拦截器
 * 用于日志打印、权限验证
 * @author liuyao
 */
@Slf4j
public class AccessTokenInterceptor implements HandlerInterceptor {

    /**
     * 本线程存储计时器
     */
    private static final ThreadLocal<StopWatch> TIME = new ThreadLocal<>();

    /**
     * 本线程存储日志信息
     */
    private static final ThreadLocal<StringBuilder> LOG_INFO = new ThreadLocal<>();


    /**
     * 在请求之前需要处理的内容
     * @param request   请求对象
     * @param response  返回对象
     * @param handler   handler对象
     * @return          true or false
     * @throws Exception    异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 生成请求id
        String requestId = String.valueOf(UUID.randomUUID()).replaceAll("-","");
        // 请求id放在request的域中
        request.setAttribute(REQUEST_ID, requestId);
        // 请求id放在log上下文中
        MDC.put(REQUEST_ID, requestId);
        MDC.put(REQUEST_URI, request.getRequestURI());
        return true;
    }

    /**
     * 在请求之后
     * @param request       请求
     * @param response      响应
     * @param handler       handler
     * @param modelAndView  视图
     * @throws Exception    异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在请求全部完成之后
     * @param request   请求
     * @param response  响应
     * @param handler   handler
     * @param ex        异常
     * @throws Exception    异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除log上下文信息
        MDC.clear();
    }
}
