package com.spring.springboot.mobile_phone_springboot.repository;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersByMobilePhoneId(int mobilePhoneId);
}
