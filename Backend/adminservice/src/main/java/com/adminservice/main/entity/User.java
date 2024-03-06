package com.adminservice.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
//	@OneToOne
//    @JoinColumn(name="gmail", referencedColumnName="emp_gmail")
//    @JoinColumn(name="guid", referencedColumnName="emp_guid")
//	@JoinColumn(name = "gmail")
//    private Employee employee;
	
	private String guid;
    private String gmail;
	private String password;
	private boolean adminStatus;
    private String accStatus;	
}
