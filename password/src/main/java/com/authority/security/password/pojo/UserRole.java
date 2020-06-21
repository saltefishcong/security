package com.authority.security.password.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName UserRole
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:59
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name_id")
    private String userNameId;

    @Column(name = "role_id")
    private Integer roleId;
}
