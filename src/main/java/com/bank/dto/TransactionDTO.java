package com.bank.dto;

import java.math.BigDecimal;
import java.util.Date;


public class TransactionDTO {
	
	private Long id;
	
	private Date operationDate;
	
	private BigDecimal operationValue;
	
	private CustomerDTO customer;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public BigDecimal getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(BigDecimal operationValue) {
		this.operationValue = operationValue;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

}
