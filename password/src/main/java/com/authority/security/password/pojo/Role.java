package com.authority.security.password.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Role
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:58
 * @Version 1.0
 **/
@Data
@Table(name = "role")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
}
