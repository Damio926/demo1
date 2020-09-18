package com.lazy.springboot.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.springboot.demo.entity.Staff;
import com.lazy.springboot.demo.entity.Student;
import com.lazy.springboot.demo.service.StaffService;
import com.lazy.springboot.demo.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffServiceImpl staffService;

    /**
     * 查询所有员工
     * 当没有条件的时候，查询全部
     * 有条件查询单条
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("query")
    public String QueryStaff(Integer id,Model model){
        if(null != id){
            Staff list = staffService.queryById(id);
            model.addAttribute("list",list);
        }else {
            List<Staff> list = staffService.queryStaff();
            model.addAttribute("list",list);
        }
        return "staff/query";
    }
    /**
     * 添加一个学生
     * @param staff
     * @param model
     * @return
     */
    @RequestMapping("insert")
    public String insert(Staff staff, Model model){
        int stu = staffService.insertStaff(staff);
//        System.out.println(stu);
//        if (stu == 1){
////            model.addAttribute("row",stu);
//            return "redirect:/staff/query";
//        }
//        return "error";
        return "redirect:/staff/query";
    }

    /**
     * 删除一个学生
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer id){
        int flag = staffService.deleteStaff(id);
        return "redirect:/staff/query";
    }

    /**
     * 修改一个学生
     * @param staff
     * @return
     */
    @RequestMapping("update")
    public String update(Staff staff){
        int flag = staffService.updateStaff(staff);
        return "redirect:/staff/query";
    }

    /**
     * 查询一个学生
     * @param id
     * @return
     */
    @RequestMapping("selectId")
    public String selectById(Integer id,Model model){
        Staff flag = staffService.queryById(id);
        model.addAttribute("staff",flag);
        return "staff/update";
    }
    /**
     * 跳转测试
     * @return
     */
    @RequestMapping("test")
    public String Test(){

        return "staff/test";
    }

//    /**
//     * 分页查询
//     * @param current
//     * @return
//     */
//    @RequestMapping("page")
//    @ResponseBody
//    public Page<Staff> selectPage(int current){
//
//        return staffService.selectPage(current);
//    }

    /**
     * 分页查询
     * @param current
     * @return
     */
    @RequestMapping("page")
    public String selectPage(Integer current,Model model,Integer level, HttpServletRequest request){
        Page<Staff> page = staffService.selectPage(current,level);
        model.addAttribute("page",page);
        request.getSession().setAttribute("level",level);


        return "staff/query";
    }
}
