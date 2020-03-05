package com.boot.ws.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.ws.model.Employee;
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{

}
