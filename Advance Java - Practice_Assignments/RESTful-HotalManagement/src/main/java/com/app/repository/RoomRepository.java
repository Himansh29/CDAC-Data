package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
