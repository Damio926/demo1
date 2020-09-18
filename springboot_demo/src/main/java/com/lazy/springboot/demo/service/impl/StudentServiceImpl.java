package com.lazy.springboot.demo.service.impl;



import com.lazy.springboot.demo.dao.IStudentDao;
import com.lazy.springboot.demo.entity.Student;
import com.lazy.springboot.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 事务在项目中对业务层方法进行管理
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;


    /**
     * 当前操作需要事务,操作异常时，回滚事务
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    /**
     * 验证事务
     * @param id
     * @return
     */
    public int deleteStudent(Integer id) {
        System.out.println("delete");
        int row = studentDao.deleteStudent(id);
        return row;
    }

//    public int deleteStudent(Integer id) {
//        int row = studentDao.deleteStudent(id);
//        int a = 3/0;
//        return row;
//    }

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> selectStudent() {
        return studentDao.selectStudent();
    }

//    @Override
//    public List<Student> selectAll(Student student) {
//        return studentDao.selectAll(student);
//    }


//    public List<Student> selectStudent(Student student) {
//        return studentDao.selectAll(student);
//    }

//    public List<Student> selectStudent(int sex, int edu) {
//        return studentDao.selectStudent(sex,edu);
//    }

    /**
     * 表示只读不可操作其他，当前业务不允许调用其它方法操作
     */
//    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Student selectOne(Integer id) {
        return studentDao.selectOne(id);
    }
}
