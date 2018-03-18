package com.pett4j.skipthedishes.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pett4j.skipthedishes.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
