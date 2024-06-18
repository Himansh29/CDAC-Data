package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.VehicalDTO;
import com.app.entity.User;
import com.app.entity.Vehical;
import com.app.exception.ResourceNotFoundException;
import com.app.repo.UserRepository;
import com.app.repo.VehicalRepository;

@Service
@Transactional
public class VehicalServiceImple implements VehicalService {

	@Autowired
	private VehicalRepository repo;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<VehicalDTO> getAllVehicals() {
		List<VehicalDTO> listOfVehicalDTO = repo.findAll().stream().map(entity -> mapper.map(entity, VehicalDTO.class)).collect(Collectors.toList());
		return listOfVehicalDTO;
	}

	@Override
	public VehicalDTO getVehicalDetailsById(Long id) {
		Vehical vehical = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehical Not FOUND"));
		return mapper.map(vehical, VehicalDTO.class);
	}

	@Override
	public VehicalDTO addVehical(VehicalDTO dto) {
		User user = repository.findByUsername(dto.getUser().getUsername());
		System.out.println(user);
		Vehical vehical = mapper.map(dto, Vehical.class);
		vehical.setUser(user);
		Vehical persistentVehical = repo.save(vehical);
		return mapper.map(persistentVehical, VehicalDTO.class);

	}

	@Override
	public ApiResponse updateVehicalDetailsById(Long id, VehicalDTO VehicalDTO) {
		Vehical vehical = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehical with id: " + id + " not found"));
		mapper.map(VehicalDTO, vehical);
		repo.save(vehical);
		return new ApiResponse("Vehical Details Saved!!");
	}

	@Override
	public ApiResponse deleteVehicalById(Long id) {
		Vehical vehical = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehical ID Invalid!!"));
		repo.delete(vehical);
		return new ApiResponse("Vehical Deleted Successfully");
	}

}
