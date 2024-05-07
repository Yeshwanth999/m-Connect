package com.adminservice.main.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;

=======
>>>>>>> fa8386315ad548bd1ca710a372f66df574d7057b
import com.adminservice.main.dto.EmployeeLeaveDto;
import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.entity.EmployeeLeaves;
import com.adminservice.main.helperclasses.ResponseMsg;

public interface AdminService {

	ResponseMsg empregister(RegistrationdDTO registrationDTO);

	String DeleteUserById(String gmail);

	List<Employee> getAllEmployees();

	Employee getEmployeeByGmail(String gmail);

	List<EmployeeLeaves> getLeaveEmployeeDetailsService(String admingmail, String leaveStatus);

	String updateLeaveStatus(List<EmployeeLeaves> employees, EmployeeLeaveDto employeeleaves);


}
