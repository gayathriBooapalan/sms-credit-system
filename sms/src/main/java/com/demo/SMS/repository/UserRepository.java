package com.demo.SMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SMS.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
