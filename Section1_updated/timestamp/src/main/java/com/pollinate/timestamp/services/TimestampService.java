package com.pollinate.timestamp.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.pollinate.timestamp.entities.timestamp;
import com.pollinate.timestamp.repository.timestamprepo;

@Service
public class TimestampService {
	@Autowired
	timestamprepo TimeStampRepo;
	public List findAll() {
		List timestamps = new ArrayList();
		TimeStampRepo.findAll().forEach(timestampvar -> timestamps.add(timestampvar));
		return timestamps;
	}
	
	public void saveTimeStamp(timestamp timestampvar) {
		
		
		TimeStampRepo.save(timestampvar);}
	
	
	


	

}
