package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.College;
import com.ty.Student;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		College c = new College();
		c.setId(101);
		c.setName("Govt");

		Student s1 = new Student();
		s1.setSid(111);
		s1.setSname("A");
		s1.setCollege(c);

		Student s2 = new Student();
		s2.setSid(222);
		s2.setSname("B");
		s2.setCollege(c);

		Student s3 = new Student();
		s3.setSid(333);
		s3.setSname("C");
		s3.setCollege(c);

//		c.setStudents(Arrays.asList(s1, s2, s3));//we have removed college_student table

		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();

		System.out.println("saved");

	}
}
