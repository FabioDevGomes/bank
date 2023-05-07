package com.bank.unit;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.bank.dto.CustomerDTO;
import com.bank.entity.Customer;
import com.bank.repository.CustomerRepository;
import com.bank.service.CustomerService;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository repository;
	
	@InjectMocks
	private CustomerService service;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void createOrSave() {
		Customer customer = new Customer();
		customer.setName("Fabio");
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setName("Fabio");
		customerDTO.setAccountNumber("123");
		customerDTO.setExclusivePlan(false);
		customerDTO.setBirthDate(LocalDate.now());
		customerDTO.setBalance(new BigDecimal(100));
		
		when(repository.save(Mockito.any())).thenReturn(customer);
		
		CustomerDTO result = service.createOrSave(customerDTO);
		
		Assertions.assertEquals("Fabio", result.getName());

		
	}

}
