package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Vehical;

public interface VehicalRepository extends JpaRepository<Vehical, Long> {
	@Query("SELECT v FROM Vehical v JOIN FETCH v.user")
    List<Vehical> findAllWithUser();
}
