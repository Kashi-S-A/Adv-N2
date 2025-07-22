package com.sb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/fetch")
	public String fetch() {
		return "product fetched";
	}

	@PostMapping("/save")
	public String save() {
		return "product saved";
	}

	@DeleteMapping("/del")
	public String del() {
		return "product deleted";
	}

	@PutMapping("/update")
	public String update() {
		return "product updated";
	}

}
