package com.bank.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Boolean exclusivePlan;
	private BigDecimal balance;
	
	@Column(unique = true)
	private String accountNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
