package com.authority.security.password.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

/**
 * @ClassName JwtUtils
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 19:02
 * @Version 1.0
 **/
public class JwtUtils {

    public static final String SUBJECT = "cc";

    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周

    //秘钥
    public static final  String APPSECRET = "niubi";

    /**
     * 生成jwt
     * @param
     * @return
     */
    public static String geneJsonWebToken(UsernamePasswordAuthenticationToken authenticationToken){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",((User)authenticationToken.getPrincipal()).getUsername())
                .claim("auth",authenticationToken.getAuthorities())
                .claim("app","password")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            System.out.println(claims);
            return claims;
        }catch (Exception e){ }
        return null;
    }
}
