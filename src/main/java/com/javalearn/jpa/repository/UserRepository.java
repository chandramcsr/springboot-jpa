package com.javalearn.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalearn.jpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
