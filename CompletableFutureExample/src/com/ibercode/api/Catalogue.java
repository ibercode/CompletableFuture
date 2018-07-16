package com.ibercode.api;

import java.util.List;

import com.ibercode.Product;


public interface Catalogue {

	List<Product> getAllProducts();
	
	Product getProductByName(String name);
}
