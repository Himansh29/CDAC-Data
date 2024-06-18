package com.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {

	private String msg;
	private String errDetails;
	private LocalDateTime ts;

	public ApiResponse(String msg, String errDetails) {
		super();
		this.msg = msg;
		this.errDetails = errDetails;
		this.ts = LocalDateTime.now();
	}

	public ApiResponse(String msg) {
		this.msg = msg;
	}

}
