package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Car car = new Car();
		car.setCid(101);
		car.setBrand("TATA");

		Engine engine = new Engine();
		engine.setEid(111);
		engine.setCc(1000);

		car.setEngine(engine);

		et.begin();
		em.persist(car);
		em.persist(engine);
		et.commit();

		System.out.println("saved");

	}
}
