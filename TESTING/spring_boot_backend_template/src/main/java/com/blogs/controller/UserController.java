package com.blogs.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.blogs.dto.UserDTO;
import com.blogs.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sharemyride/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody UserDTO dto) {
		System.out.println("in add emp " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmpsPaginated(@RequestParam(defaultValue = "0", required = false) int pageNumber,
			@RequestParam(defaultValue = "3", required = false) int pageSize) {
		System.out.println("in get all emps " + pageNumber + " " + pageSize);
		List<UserDTO> list = userService.getAllUsers(pageNumber, pageSize);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(list);
	}


	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long userId, @RequestBody @Valid UserDTO dto) {
		System.out.println("in update emp " + userId + " " + dto);
		return ResponseEntity.ok(userService.updateUser(userId, dto));
	}

	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long userId) {
		System.out.println("in update emp " + userId);
		return ResponseEntity.ok(userService.deleteUserDetails(userId));
	}


	}

