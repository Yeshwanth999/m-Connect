//package com.userservice.main.entity;
//
//import java.util.Set;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name="userlogin")
//public class LoginCredentials {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
//	private String Email;
//	private String Password;
//	private String ResetPassword;
//
//	
////@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
////    
////    @JoinTable(
////    		name="User_Login",
////    		joinColumns = {
////    				@JoinColumn(
////    		 		        name="loger_Id",referencedColumnName="Guid"),
////    		        @JoinColumn(
////    	    				name="loger_email",referencedColumnName="Email")
////    				
////    		},
////    		inverseJoinColumns=@JoinColumn(
////    				name="User_Id" , referencedColumnName="Guid")
////              )
////       private Set<UserEntity> users;
//    
//
//
//}
