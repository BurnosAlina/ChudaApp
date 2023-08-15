package com.example.chudaapp.user;

import com.example.chudaapp.userRole.UserRoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    UserRoleRepository userRoleRepository;

    public UserInfoMapper(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserInfoDto convertToDto(UserInfo userInfo) {
        return new UserInfoDto(userInfo.getId(), userInfo.getFirstName(), userInfo.getLastName(),
                userInfo.getEmail(), userInfo.getPassword(), userInfo.getRole().getName());
    }
}
