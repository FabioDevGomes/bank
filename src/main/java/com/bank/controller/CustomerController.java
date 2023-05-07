package com.bank.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.CustomerDTO;
import com.bank.service.CustomerService;
import com.bank.util.PageUtil;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> create(@RequestBody @Valid CustomerDTO customer) {
		CustomerDTO response = customerService.createOrSave(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> listAll(
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size) {
		
		Pageable paging = PageRequest.of(page, size);
		Page<CustomerDTO> customers = customerService.listAll(paging);
		Map<String, Object> response = PageUtil.setDefaltPageSettings(customers, "customers");
		
		return ResponseEntity.ok().body(response);
	}

}
