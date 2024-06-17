package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.ReservationDTO;
import com.app.entities.Reservation;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceIImple implements ReservationService{

	@Autowired
	private ReservationRepository repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ReservationDTO addReservation(ReservationDTO reservationDTO) {
		
		Reservation reservationEntity = mapper.map(reservationDTO, Reservation.class);
		
		repo.save(reservationEntity);
		
		return mapper.map(reservationEntity, ReservationDTO.class);
	}

	@Override
	public ApiResponse deleteReservation(Long id) {

		Reservation reservation = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation with id: " + id + " Not found"));
		
		repo.delete(reservation);
		
		return new ApiResponse("Reservation Cancled Successfully");
	}
	
	

}
