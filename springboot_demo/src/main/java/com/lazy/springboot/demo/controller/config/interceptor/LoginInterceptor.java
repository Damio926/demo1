package com.lazy.springboot.demo.controller.config.interceptor;

import com.lazy.springboot.demo.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 该方法在控制器方法调用前执行
     * 方法返回true：验证通过
     * 方法返回false：验证失败，不执行控制器方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        User user = (User)request.getSession().getAttribute("user");
////        if(user == null){
////            //跳转登录页面
////
////            return false;
////        }else {
////            return true;
////        }
//        System.out.println("当前请求："+request.getRequestURI());
//        return true;
//
//    }
}
