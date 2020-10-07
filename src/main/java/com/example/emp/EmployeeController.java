package com.example.emp;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.emp.model.Employee;
import com.example.emp.model.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class EmployeeController {

	
	//Autowired employeeRepository Object
	@Autowired
	EmployeeRepository employeeRepository;

	
	@GetMapping("/")
		public String getIndex(Model model) {
		return "index";
		}
	 
	
	//Need Model Object here to passs data to frontend
	@GetMapping("/employee") 
	public String getEmplyee(Model model) {
		//fetch list of employees
		List<Employee> listEmployees =employeeRepository.findAll();
		
		//Set the Model Object
		model.addAttribute("employees",listEmployees);
		
		//Here Return the name of HTML file or view file
		return "employee";
	}
	
	@PostMapping("/employee1")
	public Employee saveEmplyee(HttpServletRequest request,Model model) {
		System.out.println("IN Employee");
		//@ModelAttribute("employee") Employee employee
		
		long id=   Long.valueOf(request.getParameter("id"));
		String name=request.getParameter("id");
		String salary=request.getParameter("id");
		
		Employee employee =new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary( Double.valueOf(salary));
		
		Employee emp=employeeRepository.save(employee);
		if(emp!=null)
		System.out.println("Employee Saved"+emp);
		return employee;
	}
	
}
