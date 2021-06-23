package com.example.demo.employee.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.controller.EmployeeBean;

public interface EmployeeDao {

	public void saveEmployee(EmployeeBean employeeBean);
	public List<EmployeeBean> getEmployeeRecord() throws DataAccessException;
	public EmployeeBean getEmployeeRecordById(Integer id) throws DataAccessException;
}
