package com.example.chudaapp.user;

import com.example.chudaapp.userRole.UserRole;
import com.example.chudaapp.userRole.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserInfoService {

    private UserInfoRepository userInfoRepository;

    private UserRoleRepository userRoleRepository;

    private UserInfoMapper userInfoMapper;

    private PasswordEncoder passwordEncoder;

    public UserInfoService(UserInfoRepository userInfoRepository, UserRoleRepository userRoleRepository,
                           UserInfoMapper userInfoMapper, PasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.userRoleRepository = userRoleRepository;
        this.userInfoMapper = userInfoMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserInfoDto findByEmail(String email) {
        UserInfo userInfo = userInfoRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
        return userInfoMapper.convertToDto(userInfo);
    }

    @Transactional
    public void register(UserRegistrationDto dto) {
        UserInfo user = new UserInfo();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        user.setPassword(passwordHash);
        Optional<UserRole> role = userRoleRepository.findByName("ROLE_User");
        if (role.isPresent()) {
            user.setRole(role.get());
        } else {
            throw new NoSuchElementException("Nie ma takiej roli");
        }
        userInfoRepository.save(user);
    }

    public boolean isPasswordTheSame(String passwordConfirmation, UserRegistrationDto userRegistrationDto) {
        return userRegistrationDto.getPassword().equals(passwordConfirmation);
    }
}
