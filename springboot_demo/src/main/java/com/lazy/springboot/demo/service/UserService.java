package com.lazy.springboot.demo.service;

import com.lazy.springboot.demo.entity.User;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface UserService {
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
     * @param id
     * @return
     */
    int updateUser(User user);

    /**
     * 查询所有用户
     * @param user
     * @return
     */
    User queryUser(User user);

    /**
     * 查询一个用户
     * @param id
     * @return
     */
    User queryById(String name);
}
