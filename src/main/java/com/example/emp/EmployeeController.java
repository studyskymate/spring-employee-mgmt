package com.example.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.emp.model.Employee;
import com.example.emp.model.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class EmployeeController {

	
	//Autowired employeeRepository Object
	@Autowired
	EmployeeRepository employeeRepository;

	//Need Model Object here to passs data to frontend
	@GetMapping("/v2/employee/fetch") 
	public String getEmplyee(Model model) {
		//fetch list of employees
		List<Employee> listEmployees =employeeRepository.findAll();
		
		//Set the Model Object
		model.addAttribute("employees",listEmployees);
		
		//Here Return the name of HTML file or view file
		return "employee";
	}
	
	
}
