package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user = new User();
		user.setName("Manga");
		user.setEmail("manga@gmail.com");
		user.setPhone(1214127890);

		et.begin();
		em.persist(user);
		et.commit();

		System.out.println("saved");
	}
}
