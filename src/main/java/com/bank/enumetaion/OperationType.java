package com.bank.enumetaion;

public enum OperationType {
	
	WITHDRAW("withdraw"),
	DEPOSIT("deposit");
	
	private String descroption;
	

	OperationType(String description) {
		this.descroption = description;
	}

	public String getDescroption() {
		return descroption;
	}

}
