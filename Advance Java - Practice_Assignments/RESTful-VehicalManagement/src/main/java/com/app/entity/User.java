package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

	@Column(length = 69)
	private String username;

	@NotBlank
	@Column(name = "user_email")
	private String email;

	@NotBlank
	@Min(6)
	private String password;

	@NotBlank
	private String city;

	@NotBlank
	@Min(10)
	private String contactNo;

}
