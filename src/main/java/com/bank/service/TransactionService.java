package com.bank.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.CustomerDTO;
import com.bank.dto.TransactionDTO;
import com.bank.entity.Transaction;
import com.bank.enumetaion.OperationType;
import com.bank.mapper.DozerMapper;
import com.bank.repository.CustomerRepository;
import com.bank.repository.TransactionRepository;
import com.bank.request.TransactionOperationRequest;

@Service
public class TransactionService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	TransactionRepository transactionRepository;

	public TransactionOperationRequest withdrawValue(TransactionOperationRequest withDrauRequest) {
		CustomerDTO customerDTO = withdrawCustomerAccount(withDrauRequest);
		TransactionDTO transactionDTO = createWithdrawTransaction(withDrauRequest, customerDTO);
	
		transactionRepository.save(DozerMapper.parseObject(transactionDTO, Transaction.class));
		
		return withDrauRequest;
	}

	private CustomerDTO withdrawCustomerAccount(TransactionOperationRequest withDrauRequest) {
		CustomerDTO customer = customerService.consult(withDrauRequest.getCustomerId());
		
		addFeeToValue(withDrauRequest, customer);
		
		customer.setBalance(customer.getBalance().subtract(withDrauRequest.getValue()));
		customer = customerService.createOrSave(customer);
		return customer;
	}

	private void addFeeToValue(TransactionOperationRequest withDrauRequest, CustomerDTO customer) {
		BigDecimal fee = AdminstrationFee.calculateAdministrateFee(customer, withDrauRequest);
		withDrauRequest.setValue(withDrauRequest.getValue().add(fee));
	}

	public void depositValue(TransactionOperationRequest depositRequest) {
		CustomerDTO customer = depositInCustomerAccount(depositRequest);
		TransactionDTO transaction = createDepositTransaction(depositRequest, customer);
	
		transactionRepository.save(DozerMapper.parseObject(transaction, Transaction.class));
	}

	private CustomerDTO depositInCustomerAccount(TransactionOperationRequest depositRequest) {
		CustomerDTO customerDTO = customerService.consult(depositRequest.getCustomerId());
		customerDTO.setBalance(customerDTO.getBalance().add(depositRequest.getValue()));
		customerDTO = customerService.createOrSave(customerDTO);
		return customerDTO;
	}
	
	private TransactionDTO createWithdrawTransaction(TransactionOperationRequest withDrauRequest, CustomerDTO customerDTO) {
		TransactionDTO transaction = createTransaction(withDrauRequest, customerDTO);
		transaction.setOperationType(OperationType.WITHDRAW);
		
		return transaction;
	}

	private TransactionDTO createDepositTransaction(TransactionOperationRequest withDrauRequest, CustomerDTO customerDTO) {
		TransactionDTO transaction = createTransaction(withDrauRequest, customerDTO);
		transaction.setOperationType(OperationType.DEPOSIT);
		
		return transaction;
	}

	private TransactionDTO createTransaction(TransactionOperationRequest withDrauRequest, CustomerDTO customerDTO) {
		var transaction = new TransactionDTO();
		transaction.setCustomer(customerDTO);
		transaction.setOperationDate(LocalDate.now());
		transaction.setOperationValue(withDrauRequest.getValue());
		transaction.setCurrentBalance(customerDTO.getBalance());
		return transaction;
	}

	public List<TransactionDTO> consultTransactionHistory(LocalDate operationDate) {
		List<TransactionDTO> transactions = DozerMapper.parseListObjects(
				transactionRepository.findAllByOperationDate(operationDate), TransactionDTO.class);
		 
		 return transactions;
	}

}
