package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
@Data
public class BaseDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate date;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dateTime;
}
