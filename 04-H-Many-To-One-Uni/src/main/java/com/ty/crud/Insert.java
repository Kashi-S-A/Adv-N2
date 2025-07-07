package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Review;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p = new Product();
		p.setPid(101);
		p.setName("Samsung");
		p.setPrice(50000);

		Review r1 = new Review();
		r1.setRid(111);
		r1.setMsg("Good product");
		r1.setProduct(p);

		Review r2 = new Review();
		r2.setRid(222);
		r2.setMsg("Average product");
		r2.setProduct(p);

		et.begin();
		em.persist(p);
		em.persist(r1);
		em.persist(r2);
		et.commit();

		System.out.println("saved");
	}
}
