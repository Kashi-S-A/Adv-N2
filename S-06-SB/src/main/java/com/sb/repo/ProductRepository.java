package com.sb.repo;

import org.springframework.data.repository.CrudRepository;

import com.sb.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
