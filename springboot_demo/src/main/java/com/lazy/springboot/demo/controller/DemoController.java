package com.lazy.springboot.demo.controller;

import com.lazy.springboot.demo.entity.Student;
import com.lazy.springboot.demo.service.impl.StudentServiceImpl;
import com.lazy.springboot.demo.vo.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("stu")
public class DemoController {
    @Autowired
    private StudentServiceImpl studentService;
    /**
     *查询所有学生
     * @param
     * @return
     */
    @RequestMapping("hello")
    public String hello(Student student, Model model){
//        Student list = studentService.selectOne(1);
        List<Student> list = studentService.selectStudent();
//        System.out.println(list);
        model.addAttribute("list",list);
        return "select";
    }

    /**
     * 添加一个学生
     * @param student
     * @param model
     * @return
     */
    @PostMapping("insert")
    public String insert(Student student, Model model){
        int stu = studentService.insertStudent(student);
        if (stu == 1){

           model.addAttribute("row",stu);
            return "redirect:/stu/hello";
        }
        return "error";
    }

    /**
     * 修改一个学生
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(int id){
        int flag = studentService.deleteStudent(id);
        return "redirect:/stu/hello";
    }

    /**
     * 修改一个学生
     * @param student
     * @return
     */
    @RequestMapping("update")
    public String update( Student student){
        int flag = studentService.updateStudent(student);
        return "redirect:/stu/hello";
    }

    /**
     * 查询一个学生
     * @param id
     * @return
     */
    @RequestMapping("selectId")
    public String selectById(Integer id,Model model){
        Student flag = studentService.selectOne(id);
        model.addAttribute("stu",flag);
        return "stu/update";
    }
    @GetMapping("{viewName}")
    public String forWardPage(@PathVariable("viewName") String viewName){

        return "stu/"+viewName;
    }
    @RequestMapping("all")
    @ResponseBody
    public ResultBody queryall( ){
        List<Student> list = studentService.selectStudent();
        ResultBody result = new ResultBody();
        //设置返回的数据
        result.setResult(list);
        //设置状态码
        result.setCode("SUCCESS");
        return result;
    }
}
