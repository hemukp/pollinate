package com.pollinate.timestamp.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TIMESTAMP")
public class timestamp  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	public Timestamp timestampvalue;
	
	public Integer getID() {
		return id;
	}
	
	public Timestamp getTimeStamp() {
		return timestampvalue;
	}
	public void setTimeStamp() {
		this.timestampvalue = timestampvalue;
	}
	
	public void setTimeStamp(Timestamp timestampvalue) {
		
		this.timestampvalue = GetCurrentTimeStamp();
	}
		
	public Timestamp GetCurrentTimeStamp() {
		Long datetime = System.currentTimeMillis();
		Timestamp currenttimestamp = new Timestamp(datetime);
		return currenttimestamp;
		
	}
}

