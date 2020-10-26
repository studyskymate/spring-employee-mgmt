package com.dinesh.emp;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dinesh.emp.model.Employee;
import com.dinesh.emp.model.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class EmployeeController {

	
	//Autowired employeeRepository Object
	@Autowired
	EmployeeRepository employeeRepository;


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
	
	@PostMapping("/employeesave")
	public String saveEmplyee(HttpServletRequest request,Model model) {
		System.out.println("IN Employee");
		//@ModelAttribute("employee") Employee employee
		
		  try {
		long id=   Long.valueOf(request.getParameter("id"));
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		
		Employee employee =new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(Double.valueOf(salary));
		
		
		Employee emp=employeeRepository.save(employee);
		
		if(emp!=null)
		System.out.println("Employee Saved"+emp);
		
		//fetch list of employees
		List<Employee> listEmployees =employeeRepository.findAll();
		
		//Set the Model Object
		model.addAttribute("employees",listEmployees);
		
		//Here Return the name of HTML file or view file
		  } catch(Exception ex) {
	        	System.out.println("ex"+ex);
	        	model.addAttribute("error",ex);
	        }
		return "employee";
	}
	
	
	//Need Model Object here to passs data to frontend
	 @RequestMapping(path = "/delete/{id}")
	public String deleteEmplyee( @PathVariable("id") Long id,Model model) {
		//fetch list of employees
        try {
				
		System.out.println("ID to delete:"+id);
		Optional<Employee> e= employeeRepository.findById(id);
		
		Employee emp=e.get();
		
		employeeRepository.delete(emp);
		
		List<Employee> listEmployees =employeeRepository.findAll();
		
		//Set the Model Object
		model.addAttribute("employees",listEmployees);
		
		//Here Return the name of HTML file or view file
        }
        catch(Exception ex) {
        	System.out.println("ex"+ex);
        	model.addAttribute("error",ex);
        }
		return "employee";
	}

		//Need Model Object here to passs data to frontend
	 @RequestMapping(path = "/edit/{id}")
	public String editEmplyee( @PathVariable("id") Long id,Model model) {
		//fetch list of employees
        try {
				
		System.out.println("ID to Edit:"+id);
		Optional<Employee> e= employeeRepository.findById(id);
		
		Employee emp=e.get();
		
		
		//Set the Model Object
		model.addAttribute("employee",emp);
		
		//Here Return the name of HTML file or view file
        }
        catch(Exception ex) {
        	System.out.println("ex"+ex);
        	model.addAttribute("error",ex);
        }
		return "edit_employee";
	}

	
}
