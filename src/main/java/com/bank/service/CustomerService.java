package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Page<CustomerDTO> listAll(Pageable paging) {
		
		return DozerMapper.parsePage(repository.findAll(paging), CustomerDTO.class, paging);
	}

}
