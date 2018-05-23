package com.sclab12.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.sclab12.rest.service.OrderServiceImp;

public class OrderApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public OrderApplication() {
		singletons.add(new OrderServiceImp());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
