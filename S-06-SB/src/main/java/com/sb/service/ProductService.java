package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.sb.entity.Product;
import com.sb.exception.ProductNotFoundException;
import com.sb.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<String> saveProduct(Product product) {
		Product saved = productRepository.save(product);
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<String>("Product saved successfully with id : " + saved.getPid(), headers,
				HttpStatus.CREATED);
	}

	public Product findByPid(Integer id) {
		Optional<Product> opt = productRepository.findById(id);

//		if (opt.isPresent()) {
//			Product product = opt.get();
//			return product;
//		} else {
//			throw new RuntimeException("Product Not found");
//		}

		return opt.orElseThrow(() -> new ProductNotFoundException("Prodcut Not Found"));
	}

	public ResponseEntity<String> deleteProductById(Integer pid) {
		Optional<Product> opt = productRepository.findById(pid);

		if (opt.isPresent()) {
			productRepository.deleteById(pid);
			return ResponseEntity.ok().body("Deleted Successfully");
		} else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
//			return ResponseEntity.noContent().build();
		}
	}

	public String updateProduct(Integer pid, Product prod) {
		Optional<Product> opt = productRepository.findById(pid);
		if (opt.isPresent()) {
			Product product = opt.get();
			product.setName(prod.getName());
			product.setDescription(prod.getDescription());
			product.setPrice(prod.getPrice());

			productRepository.save(product);
			return "Updated Successfully";
		} else {
			return "Not found";
		}
	}

	public Page<Product> findAll(Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 10);// pageNumber starts from by default

		Page<Product> all = productRepository.findAll(pageable);

		return all;
	}

	public List<Product> sort(String param) {
		List<Product> products = productRepository.findAll(Sort.by(param).descending());
		return products;
	}

	public List<Product> filter(Product product) {

		Example<Product> example = Example.of(product);

		List<Product> all = productRepository.findAll(example);
		return all;
	}

	public List<Product> getByPrice(Double price) {
		return productRepository.getByPrice(price);
	}

	public List<Product> search(String name) {
		return productRepository.findByNameContaining(name);
	}
}
