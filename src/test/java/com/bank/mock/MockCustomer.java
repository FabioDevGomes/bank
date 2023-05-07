package com.bank.mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.bank.dto.CustomerDTO;
import com.bank.entity.Customer;

public class MockCustomer {

	public CustomerDTO mockDTO() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setName("Fabio");
		customerDTO.setAccountNumber("123");
		customerDTO.setExclusivePlan(false);
		customerDTO.setBirthDate(LocalDate.now());
		customerDTO.setBalance(new BigDecimal(100));
		
		return customerDTO;
	}

	public Customer mockEntity() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("Fabio");
		customer.setAccountNumber("123");
		customer.setExclusivePlan(false);
		customer.setBirthDate(LocalDate.now());
		customer.setBalance(new BigDecimal(100));
		
		return customer;
	}
}