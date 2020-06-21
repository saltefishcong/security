package com.authority.security.password.handler;

import com.alibaba.fastjson.JSONObject;
import com.authority.security.password.Util.JwtUtils;
import com.authority.security.password.Util.VO;
import com.authority.security.password.enums.VOEnum;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName PasswordSuccessHandler
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:24
 * @Version 1.0
 **/
@Component
public class PasswordSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        System.out.println(token.getPrincipal().toString());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JwtUtils.geneJsonWebToken(token));
    }
}
