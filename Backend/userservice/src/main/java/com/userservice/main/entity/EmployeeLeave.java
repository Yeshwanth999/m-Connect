package com.userservice.main.entity;

import java.time.LocalDate;

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
@Entity
@Table(name="employeeleaves")
public class  EmployeeLeave{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeleaves_seq")
    @SequenceGenerator(name = "employeeleaves_seq", sequenceName = "employeeleaves_seq", allocationSize = 1)
	private Long id;
	
	@Column(unique = true, nullable = true, columnDefinition = "VARCHAR(65)")
    private String gmail;
	@Column(nullable = false)
    private String admingmail;
	private int annual_leave_balance;
	private int annual_leaves_used;
	private int monthly_leave_balance;
	private int monthly_leaves_used;
	private int no_of_days_approved;
	private String leaveStatus;
	private int no_of_days_applied;
    private String type;
    private LocalDate fromDate;
    private String fromShift;
    private LocalDate toDate;
    private String toShift;
    private String reasonFor;
	private String leaveType;
    private int adminChecked;
	public void setAdminChecked(int adminChecked2) {
		
	}
 
}