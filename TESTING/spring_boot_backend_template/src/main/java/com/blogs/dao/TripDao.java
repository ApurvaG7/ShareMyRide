package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojo.Trip;
import com.blogs.pojo.User;

public interface TripDao extends JpaRepository<Trip, Long> {

}
