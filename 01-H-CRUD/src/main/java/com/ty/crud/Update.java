package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Student;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = em.find(Student.class, 106);

		if (student != null) {

			student.setStd("11th");

			et.begin();
			em.merge(student);
			et.commit();

			System.out.println("Student updated");
		} else {
			System.out.println("Not found");
		}
	}
}
