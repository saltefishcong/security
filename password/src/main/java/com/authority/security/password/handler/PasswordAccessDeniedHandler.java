package com.authority.security.password.handler;

import com.alibaba.fastjson.JSONObject;
import com.authority.security.password.Util.VO;
import com.authority.security.password.enums.VOEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName PasswordAccessDeniedHandler
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 17:53
 * @Version 1.0
 **/
@Component
public class PasswordAccessDeniedHandler implements AccessDeniedHandler {    //权限校验失败处理器
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //转换成JSON字符串
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",new VO<Object>(VOEnum.UNAUTHORIZED,null));
        httpServletResponse.getWriter().write(jsonObject.toJSONString());
    }
}
