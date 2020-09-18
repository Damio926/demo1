package com.lazy.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 用户登录User实体类
 * GetSet插件
 */
@Data
@TableName("user")
public class User {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private int id;
    /**
     * 用户名
     */
//    @TableField(value = "name")
    /**
     * 当表字段与实体类不一致时@TableField(value = "name")
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private String age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private String img;

    /**
     *  权限级别
     */
    private Integer level;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                ", level=" + level +
                '}';
    }
}
