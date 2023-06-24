package com.jspiders.SpringMVC.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspiders.SpringMVC.POJO.EmployeePOJO;
import javax.persistence.Query;

@Repository
public class EmployeeRepository {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager manager;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		manager=entityManagerFactory.createEntityManager();
	     entityTransaction=manager.getTransaction();}
	
	private static void closeConnection() {
		if (entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
	
	public EmployeePOJO addEmployee(String name, String email, long contact,String designation,double salary )
	{
		openConnection();
		entityTransaction.begin();
		EmployeePOJO employeePOJO=new EmployeePOJO();
		employeePOJO.setName(name);
		employeePOJO.setEmail(email);
		employeePOJO.setContact(contact);
		employeePOJO.setContact(contact);
		employeePOJO.setDesignation(designation);
		employeePOJO.setSalary(salary);
		manager.persist(employeePOJO);
		entityTransaction.commit();
		closeConnection();
		return employeePOJO;
	}

	public EmployeePOJO searchEmplyee(int id) {
		openConnection();
		entityTransaction.begin();
		EmployeePOJO employeePOJO=manager.find(EmployeePOJO.class, id);
		manager.persist(employeePOJO);
		entityTransaction.commit();
		closeConnection();
		return employeePOJO;
	}

	public EmployeePOJO removeEmployee(int id) {
		openConnection();
		entityTransaction.begin();
		EmployeePOJO employeePOJO=manager.find(EmployeePOJO.class, id);
		manager.remove(employeePOJO);
		
		entityTransaction.commit();
		closeConnection();
		return employeePOJO;
	}

	public List<EmployeePOJO> SearchAllEmployees() {
		openConnection();
		entityTransaction.begin();
		jpql="from EmployeePOJO";
		query=manager.createQuery(jpql);
		List<EmployeePOJO> employees=query.getResultList();
		entityTransaction.commit();
		closeConnection();
		return employees;
	}
	
          
}
