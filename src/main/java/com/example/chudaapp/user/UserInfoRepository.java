package com.example.chudaapp.user;

import com.example.chudaapp.user.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    Optional<UserInfo> findByEmail(String email);
}
