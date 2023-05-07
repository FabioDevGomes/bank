package com.bank.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.TransactionDTO;
import com.bank.request.TransactionOperationRequest;
import com.bank.service.TransactionService;
import com.bank.util.PageUtil;

@RestController
@RequestMapping("/transaction")
@Validated
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/wihdraw")
	public ResponseEntity<?> withdrawValue(@RequestBody @Valid TransactionOperationRequest withDrauRequest) {
		TransactionOperationRequest withDrauRecalculate = transactionService.withdrawValue(withDrauRequest);
		return ResponseEntity.status(HttpStatus.OK).body(withDrauRecalculate);
	}

	@PostMapping("/deposit")
	public ResponseEntity<?> depositValue(@RequestBody @Valid TransactionOperationRequest withDrauRequest) {
		transactionService.depositValue(withDrauRequest);
		return ResponseEntity.status(HttpStatus.OK).body(withDrauRequest);
	}
	
	@GetMapping("/{operationDate}")
	public ResponseEntity<?> consultTransactionHistory(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate operationDate, 
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size) {
		
		Pageable paging = PageRequest.of(page, size);
		Page<TransactionDTO> transactions = transactionService.consultTransactionHistory(operationDate, paging);
		Map<String, Object> response = PageUtil.setDefaltPageSettings(transactions, "transactions");
		
		return ResponseEntity.status(HttpStatus.OK).body(response); 
	}

}
