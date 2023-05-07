package com.bank.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;


public class PageUtil {
	
	public static Map<String, Object> setDefaltPageSettings(Page<?> page, String collectionName){
		Map<String, Object> response = new HashMap<>();
		response.put(collectionName, page.getContent());
		response.put("currentPage",  page.getNumber());
		response.put("totalItems",  page.getTotalElements());
		response.put("totalPages",  page.getTotalPages());
		
		return response;
	}

}
