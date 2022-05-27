package com.pollinate.timestamp.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pollinate.timestamp.entities.timestamp;
import com.pollinate.timestamp.services.TimestampService;
@ComponentScan({"com.pollinate.timestamp.services"})

@RestController
public class TimeStampController{
	@Autowired
	TimestampService timestampservice;
	
	@GetMapping("/api/all")
	private List getallTimeStamps() {
		return timestampservice.findAll();
		
	}
	
	@PostMapping("/api/timestamp")
	private ResponseEntity createTimeStamp(@RequestBody timestamp timestampvar) {
		try {
			Timestamp currenttimestamp = GetCurrentTimeStamp();
			timestampvar.timestampvalue = currenttimestamp;
			timestampservice.saveTimeStamp(timestampvar);
		} catch (Exception exp) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity("Time Stamp added " + timestampvar.timestampvalue, HttpStatus.CREATED);
	}
	
	public Timestamp GetCurrentTimeStamp() {
		Long datetime = System.currentTimeMillis();
		Timestamp currenttimestamp = new Timestamp(datetime);
		return currenttimestamp;
		
	}
}

