package com.sample.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.employee.model.Employee;
import com.sample.employee.service.EmployeeService;
import com.sample.employee.service.EmployeeServiceImp;

@SuppressWarnings("unused")
@Controller

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/list")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeservice.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeservice.saveEmployee(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable (value = "id")long id, Model model) {
		Employee employee=employeeservice.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		employeeservice.deleteEmployeeById(id);
		return "redirect:/list";
	}
}