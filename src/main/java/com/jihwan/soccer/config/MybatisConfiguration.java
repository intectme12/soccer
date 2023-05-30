package com.jihwan.soccer.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.jihwan.soccer", annotationClass = Mapper.class )
public class MybatisConfiguration {

}