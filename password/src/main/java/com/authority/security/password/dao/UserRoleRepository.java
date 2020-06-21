package com.authority.security.password.dao;

import com.authority.security.password.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {

    List<UserRole> findAllByUserNameId(String nameId);
}
