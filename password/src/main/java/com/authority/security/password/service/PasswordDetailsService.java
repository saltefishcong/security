package com.authority.security.password.service;

import com.authority.security.password.dao.RoleRepository;
import com.authority.security.password.dao.UserRepository;
import com.authority.security.password.dao.UserRoleRepository;
import com.authority.security.password.pojo.Role;
import com.authority.security.password.pojo.User;
import com.authority.security.password.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PasswordDetailsService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 16:13
 * @Version 1.0
 **/
@Service
public class PasswordDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNameId(username);
        if(user == null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        List<UserRole> userRoleList = userRoleRepository.findAllByUserNameId(user.getNameId());
        for (UserRole userRole : userRoleList) {
            Role role = roleRepository.findRoleById(userRole.getRoleId());
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getNameId()
                ,user.getPassword()
                ,grantedAuthorityList);
    }
}
