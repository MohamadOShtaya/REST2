package com.luv2code.springboot.curddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.curddemo.dao.EmployeeDAO;
import com.luv2code.springboot.curddemo.entity.Employee;
@Service
public class EmployeeServicesImpl implements EmployeeService {
	
	
	private EmployeeDAO employeeDAO;
	
	
    @Autowired
	public EmployeeServicesImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findall() {
		// TODO Auto-generated method stub
		return employeeDAO.findall();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleateById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleateById(theId);
	}

	

}
