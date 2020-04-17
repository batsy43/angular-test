package com.angular.api.repository;

import com.angular.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);

    List<User> findAll();
}
