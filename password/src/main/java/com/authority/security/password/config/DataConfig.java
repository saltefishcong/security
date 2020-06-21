package com.authority.security.password.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DataConfig
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 16:58
 * @Version 1.0
 **/
@Configuration
@ServletComponentScan
public class DataConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean(name = "druid_datasource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource getDruidDataSource(){
        return new DruidDataSource();
    }
}
