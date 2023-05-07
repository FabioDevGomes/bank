package com.bank.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.TransactionDTO;
import com.bank.request.TransactionOperationRequest;
import com.bank.service.TransactionService;

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
	public ResponseEntity<?> consultTransactionHistory(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate operationDate) {
		List<TransactionDTO> response = transactionService.consultTransactionHistory(operationDate);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
