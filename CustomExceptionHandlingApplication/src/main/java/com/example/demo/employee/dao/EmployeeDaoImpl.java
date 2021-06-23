package com.example.demo.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	 @PersistenceContext
	 private EntityManager entityManger;
	 
	@Override
	public List<EmployeeBean> getEmployeeRecord() throws DataAccessException{
		// TODO Auto-generated method stub
		List<EmployeeBean> employeeBeans=null;
		try {
		
			employeeBeans=(List<EmployeeBean>)getSessionFactory().openSession().createQuery("from EmployeeBean").list();
			
			
		}catch(DataAccessException e) {
			
		}
		return employeeBeans;
	}
	
	private SessionFactory getSessionFactory(){
	    Session session = entityManger.unwrap(Session.class);
	    SessionFactory sessionFactory = session.getSessionFactory(); 
	    return sessionFactory;
	}

	@Override
	public EmployeeBean getEmployeeRecordById(Integer id) throws DataAccessException {
		List<EmployeeBean> employeeBeans=null;
		try {
			
			employeeBeans=(List<EmployeeBean>)getSessionFactory().openSession().createQuery("from EmployeeBean where emp_id="+id).list();
			
			
		}catch(DataAccessException e) {
			
		}
		 return (employeeBeans.isEmpty() ? null : employeeBeans.get(0));
	}

	@Override
	public void saveEmployee(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub
		Session session=getSessionFactory().openSession();
		
		 Transaction tx=null;
		 try {
		     tx = session.beginTransaction();
		     //do some work
		     session.save(employeeBean);
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
		     session.close();
		 }
	}

}
