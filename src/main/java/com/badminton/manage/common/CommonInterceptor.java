package com.badminton.manage.common;

import com.alibaba.fastjson.JSON;
import com.badminton.manage.dto.common.CommonResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//自定义拦截器
//自定义拦截器需要实现HandleInterceptor接口
@Component
public class CommonInterceptor implements HandlerInterceptor {
    //处理器运行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Cookie [] cookies = request.getCookies();
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO(GlobalStatic.RESPONSE_CODE_SUCCESS, GlobalStatic.RESPONSE_SUCCESS_MSG);
        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {

                if (cookie.getName().equalsIgnoreCase(GlobalStatic.TOKEN_COOKIE_KEY)) {
                    System.out.println("登录态有效" + cookie.getName());
                    return true;
                }
            }
        }
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Allow-Methods","*");
//        response.setHeader("Access-Control-Expose-Headers", "*");
        System.out.println("登录态失效");
        commonResponseDTO.setCode(GlobalStatic.RESPONSE_LOGIN_FAIL);
        commonResponseDTO.setMsg("登录失效");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(commonResponseDTO));
        return false;
    }
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Allow-Methods","*");
    //处理器运行之后执行
//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        System.out.println("后置运行----b1");
//        System.out.println(handler);
//        System.out.println(modelAndView);
//    }

    //所有拦截器的后置执行全部结束后，执行该操作
//    @Override
//    public void afterCompletion(HttpServletRequest request,
//                                HttpServletResponse response,
//                                Object handler,
//                                Exception ex) throws Exception {
//        System.out.println("完成运行----c1");
//        System.out.println(handler);
//        System.out.println(ex);
//    }

    //三个方法的运行顺序为    preHandle -> postHandle -> afterCompletion
    //如果preHandle返回值为false，三个方法仅运行preHandle
}
