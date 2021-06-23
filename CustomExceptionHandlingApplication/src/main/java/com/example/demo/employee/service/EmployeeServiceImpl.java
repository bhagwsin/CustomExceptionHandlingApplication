package com.example.demo.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.controller.EmployeeBean;
import com.example.demo.employee.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public List<EmployeeBean> getEmployeeRecord(){
		// TODO Auto-generated method stub
		List<EmployeeBean> employeeBeans=null;
		try {
			employeeBeans=employeeDao.getEmployeeRecord();
		}catch(DataAccessException e) {
			e.printStackTrace();
			System.out.println("Exception inside getEmployeeRecord ---EmployeeServiceImpl");
		}
		return employeeBeans;
	}
	@Override
	public EmployeeBean getEmployeeRecordById(String Id) throws DataAccessException {
		// TODO Auto-generated method stub
		EmployeeBean employeeBeans=null;
		try {
			employeeBeans=employeeDao.getEmployeeRecordById(Integer.parseInt(Id));
		}catch(DataAccessException e) {
			System.out.println("Exception inside getEmployeeRecord ---EmployeeServiceImpl");
		}
		return employeeBeans;
	}
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			EmployeeBean employeeBean2=populateEmployeeBean(employee);
			
			employeeDao.saveEmployee(employeeBean2);
			
		} catch(Exception e) {
			
		}
		
	}
	private  EmployeeBean populateEmployeeBean(Employee employee) {
		
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmp_id(employee.getEmpId());
		employeeBean.setEmployeeName(employee.getEmpName());
		employeeBean.setEmailId(employee.getEmailId());
		employeeBean.setMobileNo(employee.getMobileNumber());
		
		return employeeBean;
	}

}
