package com.adminservice.main.security;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.adminservice.main.dto.EmployeeLeaveDto;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class MessageListener {
	
	  private final ObjectMapper objectMapper;

	    public MessageListener(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	    }

	    @RabbitListener(queues = MQConfig.QUEUE)
	    public void listener(String message) {
	        try {
	            EmployeeLeaveDto employeeLeaveDto = objectMapper.readValue(message, EmployeeLeaveDto.class);
	            System.out.println(employeeLeaveDto.toString());
	        } catch (Exception e) {
	            System.err.println("Error deserializing message: " + e.getMessage());
	        }
	    }
	}


//	@RabbitListener(queues = MQConfig.QUEUE)
//    public void listener(EmployeeLeaveDto message) {
//        System.out.println(message.toString());
//    }
//}
