package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.CustomerDTO;
import com.bank.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CustomerDTO customer) {
		customerService.createOrSave(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> consult(@PathVariable("id") Long id) {
		CustomerDTO customer = customerService.consult(id);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

}
