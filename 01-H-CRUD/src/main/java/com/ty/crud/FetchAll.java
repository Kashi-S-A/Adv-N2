package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.entity.Student;

public class FetchAll {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		String h1 = "select s from Student s";// to fetch all

//		String h2 = "select s from Student s where s.std=?1";// index based parameter
//		Query query = em.createQuery(h2);
//		query.setParameter(1, "10th");//setting data to the index

		String h3 = "select s from Student s where s.std=:standard";// naming based parameter
		Query query = em.createQuery(h3);
		query.setParameter("standard", "11th");// setting data to the standard parameter

		List<Student> list = query.getResultList();

		System.out.println("============Students=============");
		for (Student student : list) {
			System.out.println(student.getSid());
			System.out.println(student.getName());
			System.out.println(student.getStd());
			System.out.println("------------------------------");
		}
	}
}
