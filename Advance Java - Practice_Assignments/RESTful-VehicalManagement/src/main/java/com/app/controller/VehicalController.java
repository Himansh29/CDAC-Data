package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehicalDTO;
import com.app.service.VehicalService;

@RestController
@RequestMapping("/vehicals")
public class VehicalController {

	public VehicalController() {
		System.out.println("Inside 🐰🐰🐰");
	}
	
	@Autowired
	private VehicalService service;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllVehicalDetails() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getAllVehicals());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getVehicalDetailsById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getVehicalDetailsById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateVehicalDetailsById(@PathVariable Long id, @RequestBody VehicalDTO dto) {
		return ResponseEntity.status(HttpStatus.OK)
		.body(service.updateVehicalDetailsById(id, dto));
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addVehical(@RequestBody VehicalDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.addVehical(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVehicalById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.deleteVehicalById(id));
	}
}
