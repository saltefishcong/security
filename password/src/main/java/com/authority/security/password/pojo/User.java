package com.authority.security.password.pojo;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;

/**
 * @ClassName User
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:52
 * @Version 1.0
 **/
@Data
@Table(name="user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name_id")
    private String nameId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "user_info_id")
    private Integer userInfoId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "login_time")
    private Timestamp loginTime;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "register_time")
    private Timestamp registerTime;

    @Column(name = "register_channel")
    private Integer registerChannel;
}
