package com.ibercode;

import java.util.ArrayList;
import java.util.List;

import com.ibercode.api.Catalogue;

public class CatalogueImpl implements Catalogue {
	
	private List<Product> products = new ArrayList<>();

	@Override
	public List<Product> getAllProducts() {
		
		products.add(new Product("Iphone X"));
		products.add(new Product("Ipad Pro"));
		products.add(new Product("Iphone SE"));
		products.add(new Product("Apple Watch"));
		products.add(new Product("Magic Mouse"));
		
		return products;
	}

	@Override
	public Product getProductByName(String name) {
		return getAllProducts().stream()
				.filter(p -> p.getName().equals(name))
				.findFirst()
				.orElse(new Product("---"));
	}

}
