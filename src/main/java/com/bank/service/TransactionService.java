package com.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.CustomerDTO;
import com.bank.dto.TransactionDTO;
import com.bank.entity.Transaction;
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

	public void withdrawValue(TransactionOperationRequest withDrauRequest) {
		CustomerDTO customerDTO = customerService.consult(withDrauRequest.getCustomerId());
		customerDTO.setBalance(customerDTO.getBalance().subtract(withDrauRequest.getValue()));
		
		customerDTO = customerService.createOrSave(customerDTO);
		
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setCustomer(customerDTO);
		transactionDTO.setOperationDate(new Date());
		transactionDTO.setOperationValue(withDrauRequest.getValue());
	
		transactionRepository.save(DozerMapper.parseObject(transactionDTO, Transaction.class));
	}

	public void depositValue(TransactionOperationRequest withDrauRequest) {
		CustomerDTO customerDTO = customerService.consult(withDrauRequest.getCustomerId());
		customerDTO.setBalance(customerDTO.getBalance().add(withDrauRequest.getValue()));

		customerDTO = customerService.createOrSave(customerDTO);
		
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setCustomer(customerDTO);
		transactionDTO.setOperationDate(new Date());
		transactionDTO.setOperationValue(withDrauRequest.getValue());
	
		transactionRepository.save(DozerMapper.parseObject(transactionDTO, Transaction.class));
	}

	public List<TransactionDTO> consultTransactionHistory(Date operationDate) {
		List<TransactionDTO> transactions = DozerMapper.parseListObjects(
				transactionRepository.findAllByOperationDate(operationDate), TransactionDTO.class);
		 
		 return transactions;

	}

}
