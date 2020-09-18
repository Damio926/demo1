package com.lazy.springboot.demo.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.springboot.demo.dao.StaffDao;
import com.lazy.springboot.demo.entity.Staff;

import com.lazy.springboot.demo.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
@Repository("staffDapImpl")
public class StaffDapImpl implements StaffDao {
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 添加
     * @param staff
     * @return
     */
    @Override
    public int insertStaff(Staff staff) {
        return staffMapper.insert(staff);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteStaff(Integer id) {
        return staffMapper.deleteById(id);
    }

    /**
     * 修改
     * @param staff
     * @return
     */
    @Override
    public int updateStaff(Staff staff) {
        return staffMapper.updateById(staff);
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List<Staff> queryStaff() {
        QueryWrapper<Staff> wrapper = new QueryWrapper<Staff>();
//        wrapper.eq("id",id);

        return staffMapper.selectList(wrapper);
    }

    /**
     * 单条查询
     * @param id
     * @return
     */
    @Override
    public Staff queryById(Integer id) {
        return staffMapper.selectById(id);
    }

    @Override
    public Page<Staff> selectPage(Integer current,Integer level) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<Staff>();
        System.out.println(level+"+++++++++++++++");
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        //创建Page对象
        Page<Staff> page = new Page<Staff>();
        page.setCurrent(current);
        page.setSize(5);
        wrapper.orderByAsc("id");
        return staffMapper.selectPage(page,wrapper);
    }


}
