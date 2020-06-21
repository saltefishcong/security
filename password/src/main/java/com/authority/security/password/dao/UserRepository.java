package com.authority.security.password.dao;

import com.authority.security.password.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 16:01
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByNameId(String name);
}
