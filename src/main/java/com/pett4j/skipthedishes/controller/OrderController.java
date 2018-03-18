package com.pett4j.skipthedishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pett4j.skipthedishes.entity.Order;
import com.pett4j.skipthedishes.entity.Product;
import com.pett4j.skipthedishes.exception.OrderException;
import com.pett4j.skipthedishes.service.OrderService;

@Controller
@RequestMapping(path="/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping(consumes = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createOrder(@RequestBody Order order) {
		orderService.create(order);
	}
	
	@PatchMapping(consumes = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<?>  updatePartial(@RequestBody Order order) {
		ResponseEntity<?> result = null;
		
		try {
			orderService.updatePartial(order);
			result = new ResponseEntity<>(HttpStatus.OK);
		} catch (OrderException e) {
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable(name="id", required=true)Long id) {
		Order order;
		try {
			order = orderService.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}
