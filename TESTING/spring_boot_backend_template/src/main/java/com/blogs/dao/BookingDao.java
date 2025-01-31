package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojo.Booking;
import com.blogs.pojo.User;

public interface BookingDao extends JpaRepository<Booking, Long> {

}
