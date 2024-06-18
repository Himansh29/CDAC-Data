package com.app.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

	@NotBlank
	private String username;

	@NotBlank
	private String email;

	@NotBlank
	@Min(6) @Max(20)
	private String password;

	@NotBlank
	private String city;

	@NotBlank
	@Min(10)
	private String contactNo;
}
