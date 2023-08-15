package com.example.chudaapp.userRole;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    public UserRoleService(UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = userRoleMapper;
    }

    public Set<UserRoleDto> findAll() {
        Iterable<UserRole> allUserRoles = userRoleRepository.findAll();
        Set<UserRoleDto> userRolesDto = new HashSet<>();
        for (UserRole userRole : allUserRoles) {
            userRolesDto.add(userRoleMapper.convertToDto(userRole));
        }
        return userRolesDto;
    }
}
