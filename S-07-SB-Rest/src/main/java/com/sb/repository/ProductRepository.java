package com.sb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sb.entity.Product;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findByPrice(@Param(value = "price") Double price, Pageable pageable);
	
	Page<Product> findByNameContaining(@Param(value = "name")String name,Pageable pageable);
}