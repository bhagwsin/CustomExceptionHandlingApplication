package com.example.demo.employee.service;

import java.util.List;

import com.example.demo.controller.EmployeeBean;
import com.example.demo.model.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public List<EmployeeBean> getEmployeeRecord();
	public EmployeeBean getEmployeeRecordById(String Id);

}
