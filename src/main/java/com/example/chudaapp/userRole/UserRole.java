package com.example.chudaapp.userRole;

import com.example.chudaapp.user.UserInfo;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "role")
    private Set<UserInfo> userInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Set<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }
}
