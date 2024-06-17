package com.app.dto;

import com.app.entities.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

	private Integer roomNumber;

	private Type type;

	private double price;

	private boolean availability;
}
