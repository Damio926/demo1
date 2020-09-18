package com.lazy.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazy.springboot.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("studentMapper")
public interface StudentMapper extends BaseMapper<Student> {

//    List<Student> selectList();
}
