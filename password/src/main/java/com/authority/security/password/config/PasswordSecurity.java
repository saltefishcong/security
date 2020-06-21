package com.authority.security.password.config;

import com.authority.security.password.handler.PasswordFailureHandler;
import com.authority.security.password.handler.PasswordSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName PasswordSecurity
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:21
 * @Version 1.0
 **/
@Configuration
public class PasswordSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    public PasswordSuccessHandler successHandler;

    @Autowired
    public PasswordFailureHandler failureHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //自定义登录页
//                .loginPage("/login.html")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                //权限不足设置
                .and()
                //访问资源授权设置
                .authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and();
//        http.cors().disable();           //关闭cors攻击验证
//        http.csrf().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
