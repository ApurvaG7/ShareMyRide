package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojo.User;

public interface UserDao extends JpaRepository<User, Long> {

}
