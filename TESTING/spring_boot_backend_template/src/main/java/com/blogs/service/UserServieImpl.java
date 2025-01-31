package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blogs.customExceptions.ResourceNotFoundException;
import com.blogs.dao.BookingDao;
import com.blogs.dao.TripDao;
import com.blogs.dao.UserDao;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.UserDTO;
import com.blogs.pojo.User;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServieImpl implements UserService {
	
	
	@Autowired
	TripDao tripDao;
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Override
	public List<UserDTO> getAllUsers(int pageNumber,int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<User> userList = userDao.findAll(pageable).getContent();
		return userList.
				stream()
				.map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());

	}

	@Override
	public ApiResponse deleteUserDetails(Long userId) {
		User u= userDao.findById(userId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
		userDao.delete(u);
		return new ApiResponse("User Details of User ID :  " + u.getUserId() + " is deleted ! ");
		
	}

	@Override
	public UserDTO addNewUser(UserDTO dto) {
			User userEntity = mapper.map(dto, User.class);
			User savedUser= userDao.save(userEntity);
			System.out.println("New User Added with User ID: " + userEntity.getUserId()+ " " + savedUser.getUserId());
			return mapper.map(savedUser, UserDTO.class);			
	}

	
	@Override
	public UserDTO updateUser(Long userId, UserDTO dto) {
		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID , User not found !"));
			mapper.map(dto, user);
			System.out.println("After mapping " + user);	
			dto.setUserId(userId);
			return dto;
	}

	@Override
	public UserDTO getUserDetails(Long deptId, Long userId) {
		User user= userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID!!!"));
		return mapper.map(user, UserDTO.class);

	}

}
