package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Student;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Student fetched = em.find(Student.class, 101);

		if (fetched != null) {
			System.out.println("Sid : " + fetched.getSid());
			System.out.println("Name : " + fetched.getName());
			System.out.println("Std : " + fetched.getStd());
		} else {
			System.out.println("Not found");
		}
	}
}
