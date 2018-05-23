package com.sclab12.rest.service;
import javax.ws.rs.core.Response;
import com.sclab12.rest.model.*;
public interface OrderService {
	
	
	public Response addOrder(Order order);
	
	public Response deleteOrder(int id);
	
	public Order getOrder(int id);
	
	public Order[] getAllOrders();
}
