package com.sb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/fetch")
	public String fetch() {
		return "record fetched";
	}

	@PostMapping("/save")
	public String save() {
		return "record saved";
	}

	@DeleteMapping("/del")
	public String del() {
		return "record deleted";
	}

	@PutMapping("/update")
	public String update() {
		return "record updated";
	}

}
