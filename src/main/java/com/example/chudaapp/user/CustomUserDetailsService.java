package com.example.chudaapp.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserInfoService userInfoService;

    public CustomUserDetailsService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoDto user = userInfoService.findByEmail(username);
        return createUserDetails(user);
    }

    private UserDetails createUserDetails(UserInfoDto user) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRoleName());
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.singletonList(authority))
                .build();
    }
}
