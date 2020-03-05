package com.boot.ws.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.ws.model.Employee;
import com.boot.ws.repo.EmployeeRepository;
import com.boot.ws.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
   private EmployeeRepository repo;
	public Integer save(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getEmpId();
	}
	
	public List<Employee> getAllEmployess() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Employee> getOneEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return repo.findById(empId);
	}

	public boolean isExist(Integer empId) {
		// TODO Auto-generated method stub
		return repo.existsById(empId);
	}

	public void delete(Integer empId) {
		// TODO Auto-generated method stub
		repo.deleteById(empId);
		
	}

	public void update(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
		
	}



	
}
