package com.donkey.config;

import com.donkey.interceptor.AccessTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义注册配置
 * @author liuyao
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 注入拦截器
     * @return AccessTokenInterceptor
     */
    @Bean
    public AccessTokenInterceptor accessTokenInterceptor() {
        return new AccessTokenInterceptor();
    }

    /**
     * 添加拦截器
     * @param registry  注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义的token拦截器，然后配置拦截器的规则
        registry.addInterceptor(accessTokenInterceptor())
                // 添加此拦截器匹配的 所有请求路径
                .addPathPatterns("/**")
                // 此拦截器需要排除的请求路径
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/file/**")
                .excludePathPatterns("/error/**");
    }
}
