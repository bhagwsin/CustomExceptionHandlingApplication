package com.example.demo.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import net.bytebuddy.implementation.bind.annotation.Empty;

@Entity
@Table(name="employee")
public class EmployeeBean {

	@Id
	private Integer emp_id;
	
	@Column(name="emp_name")
	private String employeeName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile_no")
	private Long mobileNo;
	
	@Column(name="email_id")
	private String emailId;
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "EmployeeBean [emp_id=" + emp_id + ", employeeName=" + employeeName + ", address=" + address
				+ ", mobileNo=" + mobileNo + "]";
	}
	
}
