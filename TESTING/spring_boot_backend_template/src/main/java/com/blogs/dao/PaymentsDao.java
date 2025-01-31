package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojo.Payments;
import com.blogs.pojo.User;

public interface PaymentsDao extends JpaRepository<Payments, Long> {

}
