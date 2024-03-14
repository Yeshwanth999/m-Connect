package com.adminservice.main.security;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adminservice.main.dto.EmployeeLeaveDto;
import com.adminservice.main.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class MessageListener {
	
	@Autowired 
	private AdminService adminService;


	private final ObjectMapper objectMapper;

	    public MessageListener(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	    }     
	    
	    @RabbitListener(queues = MQConfig.QUEUE)
	    public void listener(String message) {
	    	
	        try {
	            EmployeeLeaveDto employeeLeaveDto = objectMapper.readValue(message, EmployeeLeaveDto.class);
	            
	            MessageExtractor messageExtractor= new MessageExtractor();
	            
	            String adminGmail = messageExtractor.extractAdminEmailFromMessage(message);
	            System.out.println(employeeLeaveDto.toString());
		        adminService.receiveLeaveRequest(employeeLeaveDto, adminGmail);

	        } catch (Exception e){
	            System.err.println("Error deserializing message: " + e.getMessage());
	            }
	        }

		   
	     }
//	@RabbitListener(queues = MQConfig.QUEUE)
//    public void listener(EmployeeLeaveDto message) {
//        System.out.println(message.toString());
//    }
//}
