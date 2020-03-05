package com.boot.ws.service;

import java.util.List;
import java.util.Optional;

import com.boot.ws.model.Employee;

public interface IEmployeeService {
	public Integer save(Employee emp);
	List<Employee> getAllEmployess();
	Optional<Employee> getOneEmployee(Integer empId);
	public boolean isExist(Integer empId);
	public void delete(Integer empId);
	public void update(Employee emp);

}
