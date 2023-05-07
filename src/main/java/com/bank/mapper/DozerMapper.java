package com.bank.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<>();
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		
		return destinationObjects;
	}

	public static <O, D> Page<D> parsePage(Page<O> origin, Class<D> destination, Pageable paging) {
		List<D> destinationObjects = new ArrayList<>();
		for (O o : origin.getContent()) {
			destinationObjects.add(mapper.map(o, destination));
		}
		
		Page<D> meetingPage = new PageImpl<D>(destinationObjects, paging, origin.getTotalElements());
		
		return meetingPage;
	}


}
