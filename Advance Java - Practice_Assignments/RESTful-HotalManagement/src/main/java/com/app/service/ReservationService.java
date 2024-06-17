package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.ReservationDTO;

public interface ReservationService {

	ReservationDTO addReservation(ReservationDTO reservationDTO);
	ApiResponse deleteReservation(Long id);
}
