package com.userservice.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "empattandence")
@Entity
public class EmpAttandence {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empattandence_seq")
	@SequenceGenerator(name = "empattandence_seq", sequenceName = "empattandence_seq", allocationSize = 1)
	private Long id;

	@Column(unique = true, nullable = true, columnDefinition = "VARCHAR(65)")
	private String gmail;

	private String guid;
	private String date;
	private String clockInTime;
	private String firstBreakStart;
	private String firstBreakEnd;
	private String secondBreakStart;
	private String secondBreakEnd;
	private String thirdBreakStart;
	private String thirdBreakEnd;
	private String clockOutTime;
	private String totalHours;
	private String breakHours;
	private String anomalous;

}
