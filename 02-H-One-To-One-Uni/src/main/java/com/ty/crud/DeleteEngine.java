package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class DeleteEngine {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Engine engine = em.find(Engine.class, 222);

		if (engine != null) {
			et.begin();
			em.remove(engine);
			et.commit();
			System.out.println("deleted");
		} else {
			System.out.println("not found");
		}
	}
}
