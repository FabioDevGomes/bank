package com.bank.unit;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

import com.bank.entity.Transaction;
import com.bank.mock.MockCustomer;
import com.bank.mock.MockTransaction;
import com.bank.repository.TransactionRepository;
import com.bank.request.TransactionOperationRequest;
import com.bank.service.CustomerService;
import com.bank.service.TransactionService;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TransactionServiceTest {
	
	private MockTransaction mockTransaction;
	private MockCustomer mockCustomer;
	
	@Mock
	public TransactionRepository repository;

	@Mock
	public CustomerService customerService;
	
	@InjectMocks
	public TransactionService service;
	

	@BeforeEach
	void setUp() throws Exception {
		mockTransaction = new MockTransaction();
		mockCustomer = new MockCustomer();
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void withdrawRateOnePercentValueTest() {
		Transaction transaction = mockTransaction.mockEntity();
		
		when(repository.save(Mockito.any())).thenReturn(transaction);
		when(customerService.consult(Mockito.any())).thenReturn(mockCustomer.mockDTO());
		when(customerService.createOrSave(Mockito.any())).thenReturn(mockCustomer.mockDTO());
		
		TransactionOperationRequest result = service.withdrawValue(mockTransaction.mockRequest1000());
		
		assertEquals(new BigDecimal(1010), result.getValue());
	}

	@Test
	void withdrawRate04PercentValueTest() {
		Transaction transaction = mockTransaction.mockEntity();
		
		when(repository.save(Mockito.any())).thenReturn(transaction);
		when(customerService.consult(Mockito.any())).thenReturn(mockCustomer.mockDTO());
		when(customerService.createOrSave(Mockito.any())).thenReturn(mockCustomer.mockDTO());
		
		TransactionOperationRequest result = service.withdrawValue(mockTransaction.mockRequest200());
		
		assertEquals(new BigDecimal(200.800).setScale(3, RoundingMode.HALF_UP), result.getValue().setScale(3, RoundingMode.HALF_UP));
	}

	@Test
	void withdrawRate0PercentValueTest() {
		Transaction transaction = mockTransaction.mockEntity();
		
		when(repository.save(Mockito.any())).thenReturn(transaction);
		when(customerService.consult(Mockito.any())).thenReturn(mockCustomer.mockDTO());
		when(customerService.createOrSave(Mockito.any())).thenReturn(mockCustomer.mockDTO());
		
		TransactionOperationRequest result = service.withdrawValue(mockTransaction.mockRequest100());
		
		assertEquals(new BigDecimal(100), result.getValue());
	}

	//@Test
	void withdrawCustomerAccountDebitTest() {
		
	}

}
