package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation extends BaseEntity {

	@NotBlank
	@Column(name = "reservation_name")
	private String name;
	
	@NotNull
	@Column(name = "check_in_name")
	private LocalDate checkInDate;
	
	@NotNull
	@Column(name = "check_out_date")
	private LocalDate checkOutDate;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Room room;
	
	@Min(69)
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Reservation(@NotBlank String name, @NotNull LocalDate checkInDate, @NotNull LocalDate checkOutDate,
			Room room, @NotBlank double price) {
		super();
		this.name = name;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
		this.price = price;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long id, LocalDate creationDate, LocalDateTime updationTS) {
		super(id, creationDate, updationTS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reservation [name=" + name + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", room=" + room + ", price=" + price + "]";
	}
	
	
}
