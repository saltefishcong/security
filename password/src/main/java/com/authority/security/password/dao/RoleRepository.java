package com.authority.security.password.dao;

import com.authority.security.password.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 16:03
 * @Version 1.0
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findRoleById(Integer id);
}
