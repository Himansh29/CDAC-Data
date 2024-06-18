package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.VehicalDTO;

public interface VehicalService {

	List<VehicalDTO> getAllVehicals();

	VehicalDTO getVehicalDetailsById(Long id);

	VehicalDTO addVehical(VehicalDTO dto);

	ApiResponse updateVehicalDetailsById(Long id, VehicalDTO VehicalDTO);

	ApiResponse deleteVehicalById(Long id);

}
