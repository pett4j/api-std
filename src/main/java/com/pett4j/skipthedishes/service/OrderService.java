package com.pett4j.skipthedishes.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pett4j.skipthedishes.entity.Order;
import com.pett4j.skipthedishes.entity.Product;
import com.pett4j.skipthedishes.entity.StatusEnum;
import com.pett4j.skipthedishes.exception.OrderException;
import com.pett4j.skipthedishes.jpa.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void create(Order order) {
		if(Objects.isNull(order.getStatus())){
			order.setStatus(StatusEnum.CREATED);
		}
		
		orderRepository.save(order);
	}
	
	public void updatePartial(Order order) throws OrderException {
		if (Objects.isNull(order) || Objects.isNull(order.getId())) {
			throw new OrderException("Order and order id cannot be null.");
		}
		
		Order persistedOrder = orderRepository.findById(order.getId()).orElseGet(null);

		if(Objects.isNull(persistedOrder)) {
			throw new OrderException("Order not found.");
		}
		
		if(Objects.nonNull(order.getDate())){
			persistedOrder.setDate(order.getDate());
		}
		
		if(Objects.nonNull(order.getCustomerId())){
			persistedOrder.setCustomerId(order.getCustomerId());
		}

		if(Objects.nonNull(order.getDeliveryAddress())){
			persistedOrder.setDeliveryAddress(order.getDeliveryAddress());
		}

		
		if(Objects.nonNull(order.getContact())){
			persistedOrder.setContact(order.getContact());
		}
		
		if(Objects.nonNull(order.getStoreId())){
			persistedOrder.setStoreId(order.getStoreId());
		}
		
		if(Objects.nonNull(order.getOrderItems()) && order.getOrderItems().isEmpty()){
			persistedOrder.setOrderItems(order.getOrderItems());
		}
		
		if(Objects.nonNull(order.getTotal())){
			persistedOrder.setTotal(order.getTotal());
		}
		
		if(Objects.nonNull(order.getStatus())){
			persistedOrder.setStatus(order.getStatus());
		}
		
		if(Objects.nonNull(order.getLastUpdate())){
			persistedOrder.setLastUpdate(order.getLastUpdate());
		}
		
		if(Objects.nonNull(order.getTotal())){
			persistedOrder.setTotal(order.getTotal());
		}

		orderRepository.save(persistedOrder);
	
	}

	public Order findById(Long id) throws Exception {
		Optional<Order> orders = orderRepository.findById(id);
		
		return orders.orElseThrow(() -> new Exception("Product Not found"));
	}
}
