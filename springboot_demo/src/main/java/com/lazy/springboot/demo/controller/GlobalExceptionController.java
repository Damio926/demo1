package com.lazy.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理控制器
 */
@Controller
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerNullPoitException(Exception e, Model model){
        String message = e.getMessage();
        message=message==null?e.getClass().getName():message;
        model.addAttribute("message",message);
        //判断客户端是否为AJAX请求
        return "error";
    }
}
