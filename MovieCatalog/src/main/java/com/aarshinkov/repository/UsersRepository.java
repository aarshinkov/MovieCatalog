package com.aarshinkov.repository;

import com.aarshinkov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
