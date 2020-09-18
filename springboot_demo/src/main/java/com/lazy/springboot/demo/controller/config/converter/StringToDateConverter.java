package com.lazy.springboot.demo.controller.config.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义数据类型转换器
 * String->Date
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {

        DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(s);
        try {
           return da.parse(s);
        } catch (ParseException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}
