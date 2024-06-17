package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Room extends BaseEntity {

	@NotNull
	@Column(name = "room_number")
	private Integer roomNumber;

	@Enumerated(EnumType.STRING)
	private Type type;

	@Column(name = "room_price", nullable = false)
	private double price;

	@Column(name = "is_available", nullable = false)
	private boolean availability;

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Room(@NotNull Integer roomNumber, Type type, double price, boolean availability) {
		super();
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.availability = availability;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(Long id, LocalDate creationDate, LocalDateTime updationTS) {
		super(id, creationDate, updationTS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", type=" + type + ", price=" + price + ", availability="
				+ availability + "]";
	}

}
