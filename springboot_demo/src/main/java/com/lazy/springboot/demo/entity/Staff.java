package com.lazy.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 员工信息实体类
 */

/**
 * 生成GetSet方法
 */
@Data
@TableName("staff")
public class Staff {

    /**
     * 员工编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 员工姓名
     */
//    @TableField(value = "name")
    /**
     * 当表字段与实体类不一致时@TableField(value = "name")
     */
    private String name;
    /**
     * 科目代码
     */
    private String subject;
    /**
     *  校区代号
     */
    private Integer part;
    /**
     *  权限级别
     */
    private Integer level;

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", part=" + part +
                ", level=" + level +
                '}';
    }
}
