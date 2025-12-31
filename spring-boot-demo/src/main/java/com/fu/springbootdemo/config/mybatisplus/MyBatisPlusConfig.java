package com.fu.springbootdemo.config.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//TODO 如果使用这个方式的话,记得一定要指定 sqlSessionTemplateRef 或 sqlSessionFactoryRef https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start-for-building-native-image#how-to-use-mapperscan
@MapperScan(basePackages = "com.fu.springbootdemo.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //添加分页插件。单数据源，如：MySQL
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //添加分页插件。多数据源
//        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}

