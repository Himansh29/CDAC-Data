package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.UserDTO;
import com.app.entity.User;
import com.app.repo.UserRepository;

@Service 
@Transactional
public class UserServiceImple {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public UserDTO addUser(UserDTO dto) {
		User user = mapper.map(dto, User.class);
		repository.save(user);
		return mapper.map(user, UserDTO.class);
	}
}
