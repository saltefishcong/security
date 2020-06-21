package com.authority.security.password.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @ClassName DruidStatFilter
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 17:09
 * @Version 1.0
 **/
@WebFilter(filterName = "druid_webStat_filter"
        , urlPatterns = {"*"}
        , initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.jpg,*.png,*.gif,*.ico,*.css,/druid/*")
        //配置本过滤器放行的请求后缀
})
public class DruidStatFilter extends WebStatFilter {
}
