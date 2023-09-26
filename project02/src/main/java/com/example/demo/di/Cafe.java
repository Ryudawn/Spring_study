package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cafe {

	@Autowired
	Manager manager;

	public Manager getManager() {
		return manager;
	}
	
}
