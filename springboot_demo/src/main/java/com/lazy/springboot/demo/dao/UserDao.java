package com.lazy.springboot.demo.dao;

import com.lazy.springboot.demo.entity.User;

import java.util.List;

/**
 * 用户接口
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询所有用户
     * @param
     * @return
     */
    User queryUser(User user);
    /**
     * 查询一个用户
     * @param id
     * @return
     */
//    User queryById(Integer id);
     User queryByName(String name);
}
