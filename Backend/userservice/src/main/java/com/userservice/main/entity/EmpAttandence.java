package com.userservice.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="empattandence")
@Entity
public class EmpAttandence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String guid;
	private String gmail;
	private String  clockInTime;
	private String clockOutTime;
	private String totalHours;
	private String  date;
	private String breakHours;
	private String anomalous;
	
  
   }
