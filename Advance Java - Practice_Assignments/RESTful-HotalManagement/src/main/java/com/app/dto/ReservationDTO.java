package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

	private String name;

	private LocalDate checkInDate;

	private LocalDate checkOutDate;

	private Room room;

	private double price;
}
