package com.registration.api.repository;

import com.registration.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);

    List<User> findAll();

    Optional<User> findByMsisdn(String msisdn);
}
