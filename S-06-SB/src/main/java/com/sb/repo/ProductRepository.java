package com.sb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
