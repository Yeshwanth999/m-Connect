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

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
//	@OneToOne
//    @JoinColumn(name="gmail", referencedColumnName="emp_gmail")
//    @JoinColumn(name="guid", referencedColumnName="emp_guid")
//	@JoinColumn(name = "gmail")
//    private Employee employee;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = true, columnDefinition = "VARCHAR(65)")
    private String gmail;
	private String guid;
	private String password;
	private boolean adminStatus;
    private String accStatus;
    private String role;
    
    
    public String[] getRolesArray() {
        return role.split(",");
    }
	
	
}
