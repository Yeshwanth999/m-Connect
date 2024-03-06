package com.userservice.main.registration.dto;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationDto {

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