package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojo.Complaints;
import com.blogs.pojo.User;

public interface ComplaintsDao extends JpaRepository<Complaints, Long> {

}
