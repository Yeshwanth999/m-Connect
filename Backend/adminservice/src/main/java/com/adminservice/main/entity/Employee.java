package com.adminservice.main.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Data
@AllArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private User user;

	private String guid;
	@Column(unique = true, nullable = true, insertable = false, updatable = false, columnDefinition = "VARCHAR(65)")
	private String gmail;

	@Column(nullable = false, columnDefinition = "VARCHAR(40)")
	private String firstname;

	@Column(nullable = false, columnDefinition = "VARCHAR(40)")
	private String lastname;

	private String password;

	@Column(name = "dateOfBirth")
	private LocalDate dob;

	@Column(columnDefinition = "VARCHAR(40)")
	private String role;

	private boolean adminStatus;

	@Column(columnDefinition = "VARCHAR(20)")
	private String gender;

	@Column(columnDefinition = "VARCHAR(40)")
	private String blood_group;

	@Column(columnDefinition = "VARCHAR(40)")
	private String marital_status;

	@Column(columnDefinition = "VARCHAR(40)")
	private String phonenumber;

	@Column(columnDefinition = "VARCHAR(40)")
	private String currentAddress;

	@Column(columnDefinition = "VARCHAR(40)")
	private String currentCountry;

	@Column(columnDefinition = "VARCHAR(40)")
	private String currentState;
	@Column(columnDefinition = "VARCHAR(40)")
	private String currentCity;
	@Column(columnDefinition = "NUMERIC(6,0)")
	private Long currentPincode;

	@Column(columnDefinition = "VARCHAR(100)")
	private String permanentAddress;
	@Column(columnDefinition = "VARCHAR(40)")
	private String permanentCountry;
	@Column(columnDefinition = "VARCHAR(40)")
	private String permanentState;
	@Column(columnDefinition = "VARCHAR(40)")
	private String permanentCity;
	@Column(columnDefinition = "NUMERIC(6,0)")
	private Long permanentPincode;
	@Column(columnDefinition = "VARCHAR(40)")
	private String stayingsince;
	@Column(columnDefinition = "VARCHAR(50)")
	private String livingincurrent;

	private String imgName;
	private String imgType;
	private String imgPath;

	@Lob
	@Column(name = "profile_img", length = 1000)
	private byte[] profileImage;

}
