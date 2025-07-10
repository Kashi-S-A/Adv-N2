package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveEmp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee employee = new Employee();
		employee.setName("manga");
		employee.setSalary(50000);

		EmployeeId eid = new EmployeeId();
		eid.setEmail("dingi@gmail.com");
		eid.setPhone(345679);

		employee.setEid(eid);

		et.begin();
		em.persist(employee);
		et.commit();

		System.out.println("saved");
	}
}
