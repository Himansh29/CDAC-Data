package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class BaseDTO {

	@NotNull
	private Long id;

	@NotNull
	private LocalDate creationDate;
	
	@NotNull
	private LocalDateTime updationTimeStamp;
}
