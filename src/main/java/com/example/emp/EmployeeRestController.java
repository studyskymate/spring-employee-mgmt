package com.example.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.model.Employee;
import com.example.emp.model.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employee/fetch")
	public List<Employee> getEmplyee() {
		
		List<Employee> listEmployees =employeeRepository.findAll();
		
		return listEmployees;
	}

	@PostMapping("/employee/save")
	public Employee saveEmplyee(@RequestBody Employee employee) {
		
		Employee emp=employeeRepository.save(employee);
		return emp;
	}

	private Employee getDummyEmployeeData() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Dinesh");
		employee.setSalary(10000.00d);
		return employee;
	}

}
