package com.bank.mock;

import java.math.BigDecimal;

import com.bank.dto.TransactionDTO;
import com.bank.entity.Transaction;
import com.bank.request.TransactionOperationRequest;

public class MockTransaction {

	
	MockCustomer mockCustomer;
	
	public MockTransaction() {
		mockCustomer = new MockCustomer();
	}
	
	public TransactionDTO mockDTO() {
		TransactionDTO transactionDTO = new TransactionDTO();
		
		transactionDTO.setCurrentBalance(new BigDecimal(1000));
		transactionDTO.setCustomer(mockCustomer.mockDTO());
		
		return transactionDTO;
	}

	public Transaction mockEntity() {
		Transaction transaction = new Transaction();
		
		return transaction;
	}

	public TransactionOperationRequest mockRequest1000() {
		TransactionOperationRequest transaction = new TransactionOperationRequest();
		transaction.setCustomerId(1L);
		transaction.setValue(new BigDecimal(1000));
		
		return transaction;
	}

	public TransactionOperationRequest mockRequest200() {
		TransactionOperationRequest transaction = new TransactionOperationRequest();
		transaction.setCustomerId(1L);
		transaction.setValue(new BigDecimal(200));
		
		return transaction;
	}

	public TransactionOperationRequest mockRequest100() {
		TransactionOperationRequest transaction = new TransactionOperationRequest();
		transaction.setCustomerId(1L);
		transaction.setValue(new BigDecimal(100));
		
		return transaction;
	}
}