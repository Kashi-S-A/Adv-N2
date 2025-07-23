package com.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entity.Product;
import com.sb.repo.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

//	private List<Product> products = new ArrayList<>();

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/fetch")
	public Product fetch(@RequestParam(name = "pid") Integer id) {
//		for (Product product : products) {
//			if (product.getPid() == id) {
//				return product;
//			}
//		}
//		return null;
		return productRepository.findById(id).get();
	}

	@GetMapping("/all")
	public Iterable<Product> fetchAll() {
//		return products;
		return productRepository.findAll();
	}

	@PostMapping("/save")
	public String save(@RequestBody Product prod) {

//		for (Product product : products) {
//			if (product.getPid() == prod.getPid()) {
//				return "already saved";
//			}
//		}
//		products.add(prod);

		productRepository.save(prod);
		return "product saved successfully";
	}

	@DeleteMapping("/del/{pid}")
	public String del(@PathVariable Integer pid) {

//		for (Product product : products) {
//			if (product.getPid() == pid) {
//				products.remove(product);
//				return "Deleted Successfully";
//			}
//		}
//
//		return "product not found";

		productRepository.deleteById(pid);
		return "Deleted successfully";
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable(name = "id") Integer pid, @RequestBody Product prod) {

//		for (Product product : products) {
//			if (product.getPid() == pid) {
//				products.remove(product);
//				product.setName(prod.getName());
//				product.setDescription(prod.getDescription());
//				product.setPrice(prod.getPrice());
//				products.add(product);
//			}
//		}
		Product product = productRepository.findById(pid).get();

		if (product != null) {
			product.setName(prod.getName());
			product.setDescription(prod.getDescription());
			product.setPrice(prod.getPrice());
			productRepository.save(product);
			return "Updated successfully";
		} else {
			return "Not found to update";
		}

	}

	@GetMapping("/head")
	public String getMethodName(@RequestHeader String token) {
		System.out.println(token);
		return "toke";
	}

}
