package com.lazy.springboot.demo.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lazy.springboot.demo.dao.UserDao;
import com.lazy.springboot.demo.entity.User;
import com.lazy.springboot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User queryUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
       wrapper.eq("username",user.getUsername());
        wrapper.eq("password",user.getPassword());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public User queryByName(String name) {
        return userMapper.selectById(name);
    }

    //    @Override
//    public User queryById(Integer id) {
//        return userMapper.selectById(id);
//    }

}
