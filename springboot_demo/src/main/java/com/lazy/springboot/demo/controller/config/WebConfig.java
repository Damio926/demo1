package com.lazy.springboot.demo.controller.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.lazy.springboot.demo.controller.config.converter.StringToDateConverter;
import com.lazy.springboot.demo.controller.config.interceptor.LoginInterceptor;
import com.lazy.springboot.demo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 在spring容器中配置一个bean，类型FastJsonHttpMessageConverter
     * @return
     */
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //设置日期格式
        fastJsonConfig.setDateFormat("yyyy-MM-dd");
        //转换编码格式
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        //序列化特征
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullNumberAsZero);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //设置响应输出字符编码方式
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        return fastJsonHttpMessageConverter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        LoginInterceptor loginInterceptor = new LoginInterceptor();
        /**
         * 注册登录检查拦截器
         */
        InterceptorRegistration registration =  registry.addInterceptor(loginInterceptor);
        /**
         * 配置拦截的URL
         */
//        registration.addPathPatterns("/**");//拦截所有的请求
//        //排除不需要拦截的请求
//        registration.excludePathPatterns("/login","/**/*.js","/**/*.css","/img/**");
    }
//    @Bean
//    public Student student(){
//        return new Student();
//    }

    /**
     * 注册数据类型转换器
     * @param registry（注册）
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        StringToDateConverter stringToDateConverter = new StringToDateConverter();
        registry.addConverter(stringToDateConverter);
    }
    //注册分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
