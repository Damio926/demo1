package com.lazy.springboot.demo.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lazy.springboot.demo.dao.IStudentDao;
import com.lazy.springboot.demo.entity.Student;
import com.lazy.springboot.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl implements IStudentDao {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public List<Student> selectStudent() {
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        return studentMapper.selectList(wrapper);
    }

    @Override
    public Student selectOne(Integer id) {
        return studentMapper.selectById(id);
    }
}
