package com.blogs.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.UserDTO;

public interface UserService {

		List<UserDTO> getAllUsers(int pageNumber,int pageSize);

		ApiResponse deleteUserDetails(Long userId);

		UserDTO addNewUser(UserDTO dto);

		UserDTO updateUser(Long userId, UserDTO dto);

		UserDTO getUserDetails(Long deptId, Long userId);

			
	
}
