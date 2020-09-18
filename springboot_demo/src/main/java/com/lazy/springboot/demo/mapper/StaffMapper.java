package com.lazy.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazy.springboot.demo.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("staffMapper")
public interface StaffMapper extends BaseMapper<Staff> {

}
