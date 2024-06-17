package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

	private String errName;
	private LocalDateTime ts;
	public ApiResponse(String errName) {
		super();
		this.errName = errName;
		this.ts = LocalDateTime.now();
	}
	
	
}
