package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchUser {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em1 = emf.createEntityManager();

		User user1 = em1.find(User.class, 50);

		System.out.println("======================================");

		System.out.println(user1);

		System.out.println("======================================");

		User user2 = em1.find(User.class, 50);

		System.out.println(user2);

		System.out.println("======================================");

		User user3 = em1.find(User.class, 60);

		System.out.println(user3);

		System.out.println("****************************************");

		EntityManager em2 = emf.createEntityManager();

		User u1 = em2.find(User.class, 50);

		System.out.println("======================================");

		System.out.println(u1);

		System.out.println("======================================");

		User u2 = em2.find(User.class, 50);

		System.out.println(u2);

		System.out.println("======================================");

		User u3 = em2.find(User.class, 60);

		System.out.println(u3);

	}
}
