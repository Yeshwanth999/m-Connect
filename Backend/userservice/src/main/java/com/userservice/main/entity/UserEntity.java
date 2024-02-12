package com.userservice.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="usersdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String guid;
    @Column(unique = true)
	private String gmail;
	private String password;
//	private String otp;
	private String role;
    private String accStatus;

	
//	public String setPassword1() {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		return "passwordEncoder.encode(Password1)";
//
//	}
	
    
	
}
