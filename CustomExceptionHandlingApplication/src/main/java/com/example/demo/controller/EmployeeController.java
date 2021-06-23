package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.service.EmployeeService;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.exception.UnathorizedException;
import com.example.demo.model.Employee;

@RestController
//@RequestMapping("/api/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	 @Autowired 
	 private Environment env; 
	 
	
	/*
	 * @Value("${module1.test}") private String test;
	 */
	 
	/*
	 * @Value("${module2.key}") private String module2;
	 */
	
	@PostMapping(value = "/addEmployees")
	public ResponseEntity<Object> addEmployee (@Valid @RequestBody Employee employee)
	{
		employeeService.saveEmployee(employee);
	    return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(path="validateUser", produces="application/json")
	public ResponseEntity<Object> validateUser(@RequestBody Employee employee){
		
		if(!employee.getEmpName().equalsIgnoreCase("admin"))
			throw new UnathorizedException("Sorry You are not authorized");
			
		return new ResponseEntity<Object>(employee,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path="getEmployee", produces="application/json")
	public List<EmployeeBean> getAllEmployee(){
		
		System.out.println("------------------------test--------------------------------"+env.getProperty("module1.test"));
		//System.out.println("------------------------module2--------------------------------"+module2);
		List<EmployeeBean> employeeBeans=null;
		try {
			employeeBeans=employeeService.getEmployeeRecord();
		}catch(Exception e) {
			System.out.println("Exception"+e.getMessage());
		}
		return employeeBeans;
	}
	@RequestMapping(path="getEmployee/{id}", produces="application/json")
	public ResponseEntity<Object> getAllEmployee(@PathVariable String id){
		
		EmployeeBean employeeBean=employeeService.getEmployeeRecordById(id);
		
		if(employeeBean==null)
			throw new ResourceNotFound("No Record found for employee Id=>"+id);
		
		return new ResponseEntity<Object>(employeeBean,HttpStatus.OK);
	}
	
	
	

}
