package com.lazy.springboot.demo.controller;

import com.lazy.springboot.demo.entity.User;
import com.lazy.springboot.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("login")
    public String LoginUser(){

        return "user/login";
    }
    @RequestMapping("loginUser")
    public String loginUser(User user,  Model model, HttpServletRequest request){
         user = userService.queryUser(user);
            if(user!=null) {
                request.getSession().setAttribute("user",user);
//                System.out.println(request.getSession().getAttribute("user"));
                return "redirect:/staff/query";
            }
        else{
        model.addAttribute("error","用户名或密码错误！");
        return "error";}


    }
}
