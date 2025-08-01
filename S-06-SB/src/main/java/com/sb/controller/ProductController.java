package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public ResponseEntity<String> save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping(value = "/fetch", produces = { "application/xml", "application/json" })
	public Product fetch(@RequestParam(name = "pid") Integer id) {
		return productService.findByPid(id);
	}

	@GetMapping("/all")
	public List<Product> fetchAll(@RequestParam Integer pageNumber) {
		return productService.findAll(pageNumber).toList();
	}

	@DeleteMapping("/del/{pid}")
	public ResponseEntity<String> deleteById(@PathVariable Integer pid) {
		return productService.deleteProductById(pid);
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable(name = "id") Integer pid, @RequestBody Product prod) {
		return productService.updateProduct(pid, prod);
	}

	@GetMapping("/head")
	public String head(@RequestHeader String token) {
		System.out.println(token);
		return "toke";
	}

	@GetMapping("/sort")
	public List<Product> sort(@RequestParam String param) {
		return productService.sort(param);
	}

	@GetMapping("/filter")
	public List<Product> filter(@RequestBody Product product) {
		return productService.filter(product);
	}

	@GetMapping("/byprice")
	public List<Product> byPrice(@RequestParam Double price) {
		return productService.getByPrice(price);
	}

	@GetMapping("/search")
	public List<Product> search(@RequestParam String name) {
		return productService.search(name);
	}

//	@GetMapping(value = "/test", consumes = { "application/json", "application/xml" },
//								 produces = { "application/json", "application/xml" }
//				)
	@GetMapping(value = "/test", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },

			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product test(@RequestBody Product product) {
		System.out.println("hi");
		return product;
	}

	@ExceptionHandler({ ArithmeticException.class, NullPointerException.class })
	public ResponseEntity<String> catchArithmeticException(Exception exception) {
		System.out.println("local");
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/ex")
	public String exceptions() {

		int [] b = {};

		System.out.println(b[1]);

		int a = 10 / 0;

		String s = null;
		s.charAt(0);

		return "Exception called";
	}

}
