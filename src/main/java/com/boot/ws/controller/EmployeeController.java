package com.boot.ws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ws.model.Employee;
import com.boot.ws.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	@PostMapping("/save")

	public ResponseEntity<String> saveStudent(@RequestBody Employee emp) {
		ResponseEntity<String> resp = null;
		try {
			Integer msg = service.save(emp);
			resp = new ResponseEntity<String>("saved" + msg, HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("data not saved", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return resp;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployes() {
		ResponseEntity<?> resp = null;
		try {
			List<Employee> std = service.getAllEmployess();
			if (std != null && !std.isEmpty())
				resp = new ResponseEntity<List<Employee>>(std, HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("data not found", HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;

	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer empId) {
		ResponseEntity<?> resp = null;
		try {
			Optional<Employee> emp = service.getOneEmployee(empId);
			if (emp != null && emp.isPresent())
				resp = new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("data not found", HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("data not found", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();

		}
		return resp;

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> delete(@PathVariable Integer empId) {
		ResponseEntity<?> resp = null;
		try {
			boolean exist = service.isExist(empId);
			if (exist) {
				service.delete(empId);
				resp = new ResponseEntity<String>("deleted", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>("not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception ee) {
			resp = new ResponseEntity<String>("not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp, @PathVariable Integer empId) {
		ResponseEntity<?> resp = null;
		try {
			boolean exist = service.isExist(empId);
			if (exist) {
				service.save(emp);
				resp = new ResponseEntity<String>("updated", HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>("not updated", HttpStatus.INTERNAL_SERVER_ERROR);

			}

		} catch (Exception e) {
			resp = new ResponseEntity<String>("not updated", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();

		}
		return resp;

	}

}
