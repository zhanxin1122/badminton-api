package com.badminton.manage.config;

import com.badminton.manage.common.CommonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    public CommonInterceptor commonInterceptor;
    /**
     * 开启跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
//        registry.addMapping("/**")
//                // 设置允许跨域请求的域名
//                .allowedOriginPatterns("*")    // 注意此处
//                // 是否允许证书（cookies）
//                .allowCredentials(true)
//                .allowedHeaders("*")
//                // 设置允许的方法
//                .allowedMethods("*");
    }

    /**
     * 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建InterceptorRegistration对象并将自定义拦截器传入;
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(commonInterceptor);
        //addPathPatterns方法（指定拦截路径，往往使用 "/**"）
//        interceptorRegistration.addPathPatterns("/**");
        //Bean加载的时候有先后顺序 默认也是0 和@Order(0) 一个作用
//        interceptorRegistration.order(-1);
        //excludePathPatterns方法（指定排除拦截路径，用于登录等部分开放接口）
//        interceptorRegistration.excludePathPatterns("/badmintonApi/user/login");

        /**
         * 与此拦截器一起使用的路径匹配器实现。
         * 这是一个可选的高级属性，只有在使用自定义路径匹配器实现时才需要，
         * 该实现支持映射元数据，而默认情况下不支持Ant路径模式。
         */

//        interceptorRegistration.pathMatcher(new PathMatcher() {
//            @Override
//            public boolean isPattern(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean match(String s, String s1) {
//                return false;
//            }
//
//            @Override
//            public boolean matchStart(String s, String s1) {
//                return false;
//            }
//
//            @Override
//            public String extractPathWithinPattern(String s, String s1) {
//                return null;
//            }
//
//            @Override
//            public Map<String, String> extractUriTemplateVariables(String s, String s1) {
//                return null;
//            }
//
//            @Override
//            public Comparator<String> getPatternComparator(String s) {
//                return null;
//            }
//
//            @Override
//            public String combine(String s, String s1) {
//                return null;
//            }
//        });
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
    }
}
