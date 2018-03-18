package com.pett4j.skipthedishes.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pett4j.skipthedishes.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
