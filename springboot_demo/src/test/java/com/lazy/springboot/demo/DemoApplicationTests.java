package com.lazy.springboot.demo;

import com.lazy.springboot.demo.entity.Student;
import com.lazy.springboot.demo.entity.User;
import com.lazy.springboot.demo.mapper.StudentMapper;
import com.lazy.springboot.demo.service.IStudentService;
import com.lazy.springboot.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.dc.pr.PRError;

//@RunWith(SpringRunner.class)

@SpringBootTest
class DemoApplicationTests {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
//        User user = new User();
//        System.out.println(userService.queryUser());
//        System.out.println(studentMapper.selectById(1));
    }


}
