package com.adminservice.main.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationdDTO {

	private String guid;
	private String gmail;
	private String firstname;
	private String lastname;
	private String password;

	private boolean adminStatus;

	private String accStatus;
	private LocalDate dob;
	private String role;
	private String gender;
	private String blood_group;
	private String marital_status;
	private String phonenumber;
	private String currentAddress;
	private String currentCountry;
	private String currentState;
	private String currentCity;
	private long currentPincode;
	private String permanentAddress;
	private String permanentCountry;
	private String permanentState;
	private String permanentCity;
	private long permanentPincode;
	private String stayingsince;
	private String livingincurrent;

	private String imgName;
	private String imgType;
	private String imgPath;
	@Lob
	@Column(name = "profile_img", length = 1000)
	private byte[] profileImage;

}