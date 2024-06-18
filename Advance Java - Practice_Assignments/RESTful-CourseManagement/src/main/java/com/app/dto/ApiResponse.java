package com.app.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ApiResponse {

	private String errMsg;
	private LocalDateTime errTS;
	public ApiResponse(String errMsg) {
		super();
		this.errMsg = errMsg;
		this.errTS = LocalDateTime.now();
	}
	
	
}
