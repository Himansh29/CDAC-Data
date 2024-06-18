package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.UserServiceImple;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserServiceImple imple;
	
	@PostMapping("/")
	public ResponseEntity<?> addUser(@RequestBody UserDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED)
		.body(imple.addUser(dto));
	}
}
