package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
