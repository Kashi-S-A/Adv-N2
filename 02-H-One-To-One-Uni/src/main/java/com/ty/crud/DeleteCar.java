package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;

public class DeleteCar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Car car = em.find(Car.class, 102);

		if (car != null) {
			et.begin();
			em.remove(car);
			et.commit();
			System.out.println("deleted");
		} else {
			System.out.println("not found");
		}
	}
}
