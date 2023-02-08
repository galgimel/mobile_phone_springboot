package com.spring.springboot.mobile_phone_springboot.repository;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
