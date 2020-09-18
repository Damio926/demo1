package com.lazy.springboot.demo.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.springboot.demo.entity.Staff;

import java.util.List;

/**
 * 员工DAO 接口
 */
public interface StaffDao {
    /**
     * 添加一个员工
     * @param staff
     * @return
     */
    int insertStaff(Staff staff);

    /**
     * 删除一个员工
     * @param id
     * @return
     */
    int deleteStaff(Integer id);

    /**
     * 修改一个员工
     * @param staff
     * @return
     */
    int updateStaff(Staff staff);

    /**
     * 查询所有员工
     * @return
     */
    List<Staff> queryStaff();

    /**
     * 查询一个员工
     * @param id
     * @return
     */
    Staff queryById(Integer id);

    /**
     * 分页查询
     * @param current
     * @return
     */

    Page<Staff> selectPage(Integer current,Integer level);

}
