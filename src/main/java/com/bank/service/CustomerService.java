package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.CustomerDTO;
import com.bank.entity.Customer;
import com.bank.mapper.DozerMapper;
import com.bank.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	public CustomerDTO createOrSave(CustomerDTO customerDTO) {
		Customer customer = repository.save(DozerMapper.parseObject(customerDTO, Customer.class));
		return DozerMapper.parseObject(customer, CustomerDTO.class);
	}

	public CustomerDTO consult(Long id) {
		return DozerMapper.parseObject(repository.findById(id).get(), CustomerDTO.class);
	}

	public List<CustomerDTO> listAll() {
		return DozerMapper.parseListObjects(repository.findAll(), CustomerDTO.class);
	}

}
