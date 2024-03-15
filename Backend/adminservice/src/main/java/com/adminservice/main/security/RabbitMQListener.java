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
	    @RabbitListener(queues = MQConfig.QUEUE)
	    public void onMessage(Message message) {
	    	EmployeeLeaveDto employeeLeaveDto = new EmployeeLeaveDto();
	    
	    	
	    	LOGGER.info("Data Recevied...!"+message.toString());
	    	adminService.receiveLeaveRequest(employeeLeaveDto,message);
	  
	    	System.out.println(employeeLeaveDto.toString()+"===============================================================");	    

	    	System.out.println("============"+message.toString());
	    }
//	        String jsonString = 
//        		"{\"id\":1,\"admingmail\":\"rohitsharma45@gmail.com\",\"annual_leave_balance\":0,\"annual_leaves_used\":0,\"monthly_leave_balance\":0,\"monthly_leaves_used\":0,\"no_of_days_approved\":0,\"leaveStatus\":null,\"guid\":\"SP2515788-M0043\",\"type\":\"Sick\",\"fromDate\":\"2024-02-28\",\"fromShift\":\"first-half\",\"toDate\":\"2024-03-05\",\"toShift\":\"second-half\",\"reasonFor\":\"Emergency\"}";
//	        message.toString();
	        // Create ObjectMapper instance
//	        ObjectMapper mapper = new ObjectMapper();

//            EmployeeLeaveDto employeeLeave = mapper.readValue(jsonString, EmployeeLeaveDto.class);
//
//	        try {
//	            
//	            MessageExtractor messageExtractor= new MessageExtractor();
//	            
////	            String adminGmail = messageExtractor.extractAdminEmailFromMessage(message);
//	            System.out.println(message.toString());
//	            
////	            EmployeeLeaveDto employeeLeaveDto = new EmployeeLeaveDto();
//	            employeeLeave.getAdmingmail();
//                employeeLeave.getAnnual_leave_balance();
//                employeeLeave.getAnnual_leaves_used();
//                employeeLeave.getMonthly_leave_balance();
//                employeeLeave.getMonthly_leaves_used();
//                employeeLeave.getNo_of_days_approved();
//                employeeLeave.getLeaveStatus();
//                employeeLeave.getGuid();
//                employeeLeave.getType();
//                employeeLeave.getFromDate();
//                employeeLeave.getFromShift();
//                employeeLeave.getToDate();
//                employeeLeave.getToShift();
//                employeeLeave.getReasonFor();
//
//	                // Now you have an EmployeeLeaveDto object
//	                System.out.println(employeeLeave);
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        adminService.receiveLeaveRequest(message, employeeLeave.getAdmingmail());
//	        }

		
}
//	@RabbitListener(queues = MQConsfig.QUEUE)
//    public void listener(EmployeeLeaveDto message) {
//        System.out.println(message.toString());
//    }
//}
