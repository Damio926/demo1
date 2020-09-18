package com.lazy.springboot.demo.service.impl;

import com.lazy.springboot.demo.dao.UserDao;
import com.lazy.springboot.demo.entity.User;
import com.lazy.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User queryUser(User user) {
        return userDao.queryUser( user);
    }

    @Override
    public User queryById(String name) {
        return userDao.queryByName(name);
    }
}
