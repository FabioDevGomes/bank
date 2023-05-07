package com.bank.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class CustomerDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Boolean exclusivePlan;
	
	@NotNull
	private BigDecimal balance;

	@NotNull
	private String accountNumber;

	@NotNull
	private LocalDate birthDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getExclusivePlan() {
		return exclusivePlan;
	}

	public void setExclusivePlan(Boolean exclusivePlan) {
		this.exclusivePlan = exclusivePlan;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
