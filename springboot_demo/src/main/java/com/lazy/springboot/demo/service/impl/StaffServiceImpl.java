package com.lazy.springboot.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.springboot.demo.dao.StaffDao;
import com.lazy.springboot.demo.entity.Staff;
import com.lazy.springboot.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现业务类
 */
@Service("staffServiceImpl")
public class StaffServiceImpl implements StaffService {
    /**
     * 装配DAO层方法
     */
    @Autowired
    private StaffDao staffDao;

    @Override
    public int insertStaff(Staff staff) {
        return staffDao.insertStaff(staff);
    }

    @Override
    public int deleteStaff(Integer id) {
        return staffDao.deleteStaff(id);
    }

    @Override
    public int updateStaff(Staff staff) {
        return staffDao.updateStaff(staff);
    }

    @Override
    public List<Staff> queryStaff() {
        return staffDao.queryStaff();
    }

    @Override
    public Staff queryById(Integer id) {
        return staffDao.queryById(id);
    }

    @Override
    public Page<Staff> selectPage(Integer current,Integer level) {
        return staffDao.selectPage(current,level);
    }
}
