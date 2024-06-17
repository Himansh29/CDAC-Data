package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	public RoomController() {
		System.out.println("☆*: .｡. o(≧▽≦)o .｡.:*☆");
	}
	
	@Autowired
	private RoomService service;
	
	@GetMapping("/") 
	public ResponseEntity<?> getAllAvailableRooms() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getAllRooms());
	}
}
