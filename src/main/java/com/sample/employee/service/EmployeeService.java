package com.sample.employee.service;

import java.util.List;
import com.sample.employee.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
