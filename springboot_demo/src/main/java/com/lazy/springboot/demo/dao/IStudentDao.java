package com.lazy.springboot.demo.dao;





import com.lazy.springboot.demo.entity.Student;

import java.util.List;

/**
 * 学生DAO接口
 */
public interface IStudentDao {
    /**
     * 添加学生
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    int deleteStudent(Integer id);

    /**
     * 修改学生
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 根据性别,学历查询学生信息
     * @param
     * @return
     */
    List<Student> selectStudent();

    /**
     * 根据学生id查询一条学生的记录
     * @param id
     * @return
     */
    Student selectOne(Integer id);
}
