package com.luv2code.springboot.curddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.curddemo.entity.Employee;


@Repository
public class EmployeeDAOHibernatImpl implements EmployeeDAO {
	
	
	private EntityManager entityManager;
	
	//set cons inje
	@Autowired
	 public EmployeeDAOHibernatImpl(EntityManager theentityManager) {
		entityManager =theentityManager;
		
	}

	@Override
	public List<Employee> findall() {
		
		Session currs = entityManager.unwrap(Session.class);
		 
		Query<Employee> q = currs.createQuery("from Employee",Employee.class);
		
		List<Employee> emp = q.getResultList();
		return emp;
	}

	@Override
	public Employee findById(int theId) {
		Session currs = entityManager.unwrap(Session.class);
		Employee emp = currs.get(Employee.class, theId);
		
		 
		return emp;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currs = entityManager.unwrap(Session.class);
		
		currs.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleateById(int theId) {
		Session currs = entityManager.unwrap(Session.class);
		Query qq = currs.createQuery(
				"delete from Employee where id=:employeeId");
		
				
	     qq.setParameter("employeeId", theId);
	     qq.executeUpdate();
	     
	     
	}

	

}
