package com.sb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	// custom queries
	@Query("SELECT p FROM Product p WHERE p.price=:prodPrice")
	public List<Product> prodByPrice(Double prodPrice);// name based parameter

	@Query("SELECT p FROM Product p WHERE p.price=?1")
	public List<Product> getByPrice(Double price);// index based parameter

	@Query("SELECT p FROM Product p WHERE p.price=?1 AND p.name=?2")
	public List<Product> getByPriceName(Double price, String name);

	@Query("SELECT p FROM Product p WHERE p.price=:prodPrice AND p.name=:prodName")
	public List<Product> prodByPriceName(Double prodPrice, String prodName);

	// custom method
	public List<Product> findByPrice(Double price);

	List<Product> findByName(String name);

	List<Product> findByPriceAndName(Double price, String name);

	List<Product> findByPriceOrName(Double price, String name);

	List<Product> findByNameContaining(String name);

	List<Product> findByPriceLessThanEqual(Double price);

}
