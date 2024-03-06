package com.adminservice.main.security;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.adminservice.main.dto.EmployeeLeaveDto;


@Component
public class MessageListener {

	@RabbitListener(queues = MQConfig.QUEUE)
    public void listener(EmployeeLeaveDto message) {
        System.out.println(message.toString());
    }
}
