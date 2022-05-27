package com.pollinate.timestamp.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.pollinate.timestamp.entities.timestamp;

@Repository
public interface timestamprepo extends JpaRepository<timestamp,Integer>{

	
	
}