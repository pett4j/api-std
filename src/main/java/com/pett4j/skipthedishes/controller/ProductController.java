package com.pett4j.skipthedishes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pett4j.skipthedishes.entity.Product;
import com.pett4j.skipthedishes.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/search/{searchText}")
	private ResponseEntity<List<Product>> findByQuery(@PathVariable(value = "searchText", required = true) String searchText){
		
		searchText = searchText.replace("+", " ");
		List<Product> products = productService.findByQuery(searchText);
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable(name="id", required=true)Long id) {
		Product product;
		try {
			product = productService.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
