package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.College;
import com.ty.Student;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		College college = em.find(College.class, 101);

		if (college != null) {
			System.out.println("----------College-----------");
			System.out.println(college.getId());
			System.out.println(college.getName());

			List<Student> students = college.getStudents();

			System.out.println("===========Students===========");

			for (Student student : students) {
				System.out.println(student.getSid());
				System.out.println(student.getSname());
				System.out.println("******************************");
			}
		} else {
			System.out.println("Not found");
		}
	}
}
