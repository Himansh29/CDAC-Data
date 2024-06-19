package com.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {

	private String msg;
	private LocalDateTime ts;
	public ApiResponse(String msg) {
		super();
		this.msg = msg;
		this.ts = LocalDateTime.now();
	}

	
	
	
	
	
}
