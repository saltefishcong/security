package com.authority.security.password.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName PasswordAuthenticationEntryPoint
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 17:59
 * @Version 1.0
 **/
public class PasswordAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                //未登录处理............
    }
}
