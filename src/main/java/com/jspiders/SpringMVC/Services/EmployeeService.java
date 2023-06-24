package com.jspiders.SpringMVC.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.SpringMVC.POJO.EmployeePOJO;
import com.jspiders.SpringMVC.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	public  EmployeePOJO addEmployee(String name, String email, long contact,String designation,double salary )
	{
		EmployeePOJO employeePOJO=repository.addEmployee(name, email, contact, designation, salary);
		return employeePOJO;
	}
	public EmployeePOJO search(int id) {
		EmployeePOJO employeePOJO=repository.searchEmplyee(id);
		
		return employeePOJO;
	}
	public void remove(int id) {
		repository.removeEmployee(id);
	}
	public List<EmployeePOJO> searchAllEmployess() {
		List<EmployeePOJO> employees=repository.SearchAllEmployees();
		return employees;
	}
	

}
