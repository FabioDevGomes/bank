package com.bank.unit;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.bank.mock.MockCustomer;
import com.bank.repository.CustomerRepository;
import com.bank.service.CustomerService;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceTest {
	
	private MockCustomer mockCustomer;
	
	@Mock
	public CustomerRepository repository;
	
	@InjectMocks
	public CustomerService service;
	

	@BeforeEach
	void setUp() throws Exception {
		mockCustomer = new MockCustomer();
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void createOrSaveTest() {
		Customer customer = mockCustomer.mockEntity();
		
		when(repository.save(Mockito.any())).thenReturn(customer);
		
		CustomerDTO result = service.createOrSave(new CustomerDTO());
		
		assertEquals("Fabio", result.getName());
		assertEquals(customer.getAccountNumber(), result.getAccountNumber());
		assertEquals(customer.getExclusivePlan(), result.getExclusivePlan());
		assertEquals(customer.getBirthDate(), result.getBirthDate());
		assertEquals(customer.getBalance(), result.getBalance());
	}

}
