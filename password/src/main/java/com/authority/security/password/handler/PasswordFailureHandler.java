package com.authority.security.password.handler;

import com.alibaba.fastjson.JSONObject;
import com.authority.security.password.Util.VO;
import com.authority.security.password.enums.VOEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName PasswordFailureHandler
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:25
 * @Version 1.0
 **/
@Component
public class PasswordFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        //转换成JSON字符串
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",new VO<Object>(VOEnum.USER_PASSWORD_ERROR,null));
        response.getWriter().write(jsonObject.toJSONString());
    }
}
