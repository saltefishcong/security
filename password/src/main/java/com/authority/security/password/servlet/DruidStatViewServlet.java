package com.authority.security.password.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @ClassName DruidStatViewServlet
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 17:12
 * @Version 1.0
 **/
@WebServlet(
        urlPatterns = {"/druid/*"}
        , initParams = {
        @WebInitParam(name = "allow", value = "127.0.0.1"),
        @WebInitParam(name = "loginUsername", value = "root"),
        @WebInitParam(name = "loginPassword", value = "root"),
        @WebInitParam(name = "resetEnable", value = "true"),  // 允许HTML页面上的“Reset All”功能
        @WebInitParam(name = "deny",value ="192.168.3.10" )   //配置访问网络黑名单
}
)
public class DruidStatViewServlet extends StatViewServlet implements Servlet {
    private static final long serialVersionUID = 1L;
}
