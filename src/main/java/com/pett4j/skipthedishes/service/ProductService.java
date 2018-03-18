package com.pett4j.skipthedishes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pett4j.skipthedishes.entity.Product;
import com.pett4j.skipthedishes.jpa.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findByQuery(String searchText) {
		Iterable<Product> products = productRepository.findAll();

		final String query = searchText.toUpperCase();

		// This isn't the best way to do. Is just use to show some java 8 code;
		// The best way is use tools like Hibernate Search or use directly
		// Elasticsearch.
		return StreamSupport.stream(products.spliterator(), false).filter(p -> {
			return (p.getName().toUpperCase().contains(query) || p.getDescription().toUpperCase().contains(query));
		}).collect(Collectors.toList());
	}
	
	public Product findById(Long id) throws Exception {
		Optional<Product> products = productRepository.findById(id);
		
		return products.orElseThrow(() -> new Exception("Product Not found"));
	}

}
