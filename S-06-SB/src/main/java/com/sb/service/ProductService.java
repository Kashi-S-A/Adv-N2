package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sb.entity.Product;
import com.sb.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public String saveProduct(Product product) {
		Product saved = productRepository.save(product);
		return "Product saved successfully with id : " + saved.getPid();
	}

	public Product findByPid(Integer id) {
		Optional<Product> opt = productRepository.findById(id);

//		if (opt.isPresent()) {
//			Product product = opt.get();
//			return product;
//		} else {
//			throw new RuntimeException("Product Not found");
//		}

		return opt.orElseThrow(() -> new RuntimeException("Prodcut Not Found"));
	}

	public String deleteProductById(Integer pid) {
		Optional<Product> opt = productRepository.findById(pid);
		if (opt.isPresent()) {
			productRepository.deleteById(pid);
			return "Deleted Successfully";
		} else {
			return "Product Not Found";
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
