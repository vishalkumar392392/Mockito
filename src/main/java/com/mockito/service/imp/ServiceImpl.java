package com.mockito.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import com.mockito.service.Service;

public class ServiceImpl {
	
	
	private Service service;

	public ServiceImpl(Service service) {
		super();
		this.service = service;
	}
	
	
	public List<String> retrieveSelectedNames(String names){
		
		List<String> namesFromService = service.retrieveNames(names);
		
		return namesFromService.stream()
				.filter(name->name.contains("spring"))
				.collect(Collectors.toList());
	}

}
