package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Student;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Student st = new Student();
		st.setSid(102);
		st.setName("Dingi");
		st.setStd("10th");

		et.begin();
		// save
		em.persist(st);

		et.commit();

		System.out.println("saved");
	}
}
