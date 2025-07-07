package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Review;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Review review = em.find(Review.class, 222);

		if (review != null) {
			System.out.println("=======Review=======");
			System.out.println(review.getRid());
			System.out.println(review.getMsg());

			System.out.println("---------Product----------");
			Product product = review.getProduct();
			System.out.println(product.getPid());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		} else {
			System.out.println("Not found");
		}
	}
}
