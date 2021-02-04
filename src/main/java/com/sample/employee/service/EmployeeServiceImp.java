package com.sample.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.employee.model.Employee;
import com.sample.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeerepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeerepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional <Employee> optional = employeerepository.findById(id);
		Employee employee=null;
		if (optional.isPresent()) {
			employee=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found for id ::"+ id);
		}		
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeerepository.deleteById(id);
	}
	
	
}
