package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entity.Company;
import com.app.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VehicalDTO {

	@NotBlank
	private String name;

	@NotNull
	private Company company;

	@NotBlank
	private String vehicalNumber;

	@NotNull
	private String vehicalType;

	@NotNull
	private UserDTO user;

}
