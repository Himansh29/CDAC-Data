package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehical extends BaseEntity{

	@Column(name = "vehicle_name", length = 20)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Company company;
	
	@Column(name = "vehicle_number", length = 20)
	private String vehicalNumber;
	
	@Column(name = "vehicle_type")
	private String vehicalType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
}
