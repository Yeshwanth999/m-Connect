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
@Table(name = "employeeleaves")
public class EmployeeLeave {

	@Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeleaves_seq")
    @SequenceGenerator(name = "employeeleaves_seq", sequenceName = "employeeleaves_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = true, columnDefinition = "VARCHAR(65)")
    private String gmail;
	
	@Column(nullable = true)
    private String admingmail;
	
=======
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeleaves_seq")
	@SequenceGenerator(name = "employeeleaves_seq", sequenceName = "employeeleaves_seq", allocationSize = 1)
	private Long id;

	@Column(unique = true, nullable = true, columnDefinition = "VARCHAR(65)")
	private String gmail;

	@Column(nullable = false)
	private String admingmail;

>>>>>>> fa8386315ad548bd1ca710a372f66df574d7057b
	private int annual_leave_balance;
	private int annual_leaves_used;
	private int monthly_leave_balance;
	private int monthly_leaves_used;
	private int no_of_days_approved;
	private String leaveStatus;
	private int no_of_days_applied;
<<<<<<< HEAD
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
 
=======
	private String type;
	private LocalDate fromDate;
	private String fromShift;
	private LocalDate toDate;
	private String toShift;
	private String reasonFor;<<<<<<<HEAD
	private String leaveType;
	private int adminChecked;

	public void setAdminChecked(int adminChecked2) {
		
	}=======>>>>>>>e1796a994376d1ee44d59ffa5745a96fbad69a25

>>>>>>> fa8386315ad548bd1ca710a372f66df574d7057b
}