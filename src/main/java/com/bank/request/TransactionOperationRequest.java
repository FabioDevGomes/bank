package com.bank.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class TransactionOperationRequest {

	@NotNull
	private BigDecimal value;

	@NotNull
	private Long customerId;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
