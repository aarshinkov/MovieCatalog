package com.aarshinkov.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserPrincipal extends User {

    private Integer userId;
    private String name;

    public UserPrincipal(String username, String password,
                         Collection<? extends GrantedAuthority> authorities, Integer userId, String name) {
        super(username, password, authorities);
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
