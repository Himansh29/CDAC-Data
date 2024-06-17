package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	private String errMsg;
	private String errDetails;
	private LocalDateTime ts;
	public ApiResponse(String msg) {
		super();
		this.errMsg = msg;
		ts = LocalDateTime.now();
	}
	
	
	
}
