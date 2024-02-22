package com.userservice.main.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
	
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
