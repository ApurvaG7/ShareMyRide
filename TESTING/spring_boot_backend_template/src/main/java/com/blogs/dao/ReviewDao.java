package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojo.Review;
import com.blogs.pojo.User;

public interface ReviewDao extends JpaRepository<Review, Long> {

}
