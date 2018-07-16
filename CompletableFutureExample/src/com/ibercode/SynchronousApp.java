package com.ibercode;

import com.ibercode.api.Catalogue;
import com.ibercode.api.ExchangeService;
import com.ibercode.api.PriceFinder;

public class SynchronousApp {

	private static Catalogue catalogue = new CatalogueImpl();
	private static PriceFinder priceFinder = new PriceFinderImpl();
	private static ExchangeService exchangeService = new ExchangeServiceImpl();

	public static void main(String[] args) throws InterruptedException {

		long initTime = System.currentTimeMillis();

		String productName = "Iphone SE";
		String currency = "EUR";
		
		calculatePrice(productName, currency);

		System.out.println("\nTime " + (System.currentTimeMillis() - initTime));
	}

	private static void calculatePrice(String productName, String currency) throws InterruptedException {
		
		Product product = catalogue.getProductByName(productName);
		double productPrice = priceFinder.getPrice(product);
		double exchangeRate = exchangeService.getExchangeRate(currency);
		double total = productPrice * exchangeRate;
		
		System.out.printf("%s cost is %.2f %s", productName, total, currency);
	}

}
