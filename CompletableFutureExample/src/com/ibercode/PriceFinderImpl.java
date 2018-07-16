package com.ibercode;

import com.ibercode.api.PriceFinder;

public class PriceFinderImpl implements PriceFinder {

	private double price = 1;

	@Override
	public double getPrice(Product product) {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switch (product.getName()) {
		case "Iphone X":
			price = 1000;
			break;
		case "Ipad Pro":
			price = 750;
			break;
		case "Iphone SE":
			price = 300;
			break;
		case "Apple Watch":
			price = 450;
			break;
		case "Magic Mouse":
			price = 100;
			break;

		default:
			break;
		}

		return price;
	}

}
