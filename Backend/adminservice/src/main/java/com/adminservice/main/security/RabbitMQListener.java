package com.adminservice.main.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adminservice.main.dto.EmployeeLeaveDto;
import com.adminservice.main.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQListener implements MessageListener {

	@Autowired
	private AdminService adminService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);

	@Override
	public void onMessage(Message message) {

		try {
			String messageBody = new String(message.getBody());
			LOGGER.info("Consuming Message: {}", messageBody);

			// Process the message using AdminService
			adminService.receiveLeaveRequest(message);
		} catch (Exception e) {
			LOGGER.error("Error processing message: {}", e.getMessage(), e);
			// Handle the exception as needed
		}

	}
}
