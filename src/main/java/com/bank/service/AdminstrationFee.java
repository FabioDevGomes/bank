package com.bank.service;

import java.math.BigDecimal;

import com.bank.dto.CustomerDTO;
import com.bank.request.TransactionOperationRequest;

public class AdminstrationFee {
	
	private static final BigDecimal MIN_FOR_FEE_04 = new BigDecimal(100); 
	private static final BigDecimal MAX_FOR_FEE_04 = new BigDecimal(300); 
	private static final BigDecimal FEE_04 = new BigDecimal(0.4); 
	private static final BigDecimal FEE_1 = new BigDecimal(1); 
	private static final BigDecimal ONE_HUNDRED  = new BigDecimal(100); 
	
	public static BigDecimal calculateAdministrateFee(CustomerDTO customer, TransactionOperationRequest withDrauRequest) {
		BigDecimal administrateFee = new BigDecimal(0); 
		if (between100and300(withDrauRequest) && !customer.getExclusivePlan()) {
			administrateFee = withDrauRequest.getValue().multiply(FEE_04).divide(ONE_HUNDRED);
		} else if (greater300(withDrauRequest) && !customer.getExclusivePlan()) {
			administrateFee = withDrauRequest.getValue().multiply(FEE_1).divide(ONE_HUNDRED);
		}
		
		return administrateFee;
	}

	private static boolean between100and300(TransactionOperationRequest withDrauRequest) {
		return withDrauRequest.getValue().compareTo(MIN_FOR_FEE_04) == 1 
				&& (withDrauRequest.getValue().compareTo(MAX_FOR_FEE_04) < 1 
						|| withDrauRequest.getValue().compareTo(MAX_FOR_FEE_04) ==0);
	}

	private static boolean greater300(TransactionOperationRequest withDrauRequest) {
		return withDrauRequest.getValue().compareTo(MAX_FOR_FEE_04) == 1;
	}

}
