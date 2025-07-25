package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.sb.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public String save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/fetch")
	public Product fetch(@RequestParam(name = "pid") Integer id) {
		return productService.findByPid(id);
	}

	@GetMapping("/all")
	public List<Product> fetchAll(@RequestParam Integer pageNumber) {
		return productService.findAll(pageNumber).toList();
	}

	@DeleteMapping("/del/{pid}")
	public String deleteById(@PathVariable Integer pid) {
		return productService.deleteProductById(pid);
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable(name = "id") Integer pid, @RequestBody Product prod) {
		return productService.updateProduct(pid, prod);
	}

	@GetMapping("/head")
	public String getMethodName(@RequestHeader String token) {
		System.out.println(token);
		return "toke";
	}

}
