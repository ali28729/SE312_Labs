package com.sclab12.rest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.sclab12.rest.model.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/order")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class OrderServiceImp implements OrderService {

	private static Map<Integer,Order> emps = new HashMap<Integer,Order>();
	
	@Override
	@POST
    @Path("/add")
	public Response addOrder(Order order) {
		GenericResponse response = new GenericResponse();
		if(emps.get(order.getId()) != null){
			response.setStatus(false);
			response.setMessage("Order Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		emps.put(order.getId(), order);
		response.setStatus(true);
		response.setMessage("Order created successfully");
		return Response.ok(response).build();
	}
	
	@POST
    @Path("/update")
	public Response updateOrder(Order order) {
		GenericResponse response = new GenericResponse();
		if(emps.get(order.getId()) == null){
			response.setStatus(false);
			response.setMessage("No order to Update");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		
		Order o=emps.get(order.getId());
		o.setFood_id(order.getFood_id());
		o.setPrice(order.getPrice());
		o.setQuantity(order.getQuantity());
		response.setStatus(true);
		response.setMessage("Order created successfully");
		return Response.ok(response).build();
	}

	@Override
	@DELETE
    @Path("/{id}/delete")
	public Response deleteOrder(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if(emps.get(id) == null){
			response.setStatus(false);
			response.setMessage("Order Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		emps.remove(id);
		response.setStatus(true);
		response.setMessage("Order deleted successfully");
		return Response.ok(response).build();
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Order getOrder(@PathParam("id") int id) {
		return emps.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Order getDummyOrder(@PathParam("id") int id) {
		Order order = new Order();
		order.setId(id);
		order.setFood_id(1);
		order.setQuantity(1);
		order.setPrice(100);
		return order;
	}

	@Override
	@GET
	@Path("/getAll")
	public Order[] getAllOrders() {
		Set<Integer> ids = emps.keySet();
		Order[] e = new Order[ids.size()];
		int i=0;
		for(Integer id : ids){
			e[i] = emps.get(id);
			i++;
		}
		return e;
	}
	

}
