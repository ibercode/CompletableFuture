package com.ibercode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.ibercode.api.Catalogue;
import com.ibercode.api.ExchangeService;
import com.ibercode.api.PriceFinder;

public class AsynchronousApp {

	private static Catalogue catalogue = new CatalogueImpl();
	private static PriceFinder priceFinder = new PriceFinderImpl();
	private static ExchangeService exchangeService = new ExchangeServiceImpl();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		long initTime = System.currentTimeMillis();
		
		String product = "Iphone SE";
		String currency = "EUR";
		
		calculatePrice(product, currency);
		
		System.out.println("\nTime " + (System.currentTimeMillis() - initTime));
		
	}
	
	private static void calculatePrice(String name, String currency) throws InterruptedException, ExecutionException {
		
		getProductCF(name)
			.thenCompose(prod -> getPriceCF(prod))
			.thenCombine(getExchangeService(currency),(price,exchangeRate) -> getTotalPrice(price, exchangeRate))
			.thenAccept(localPrice -> System.out.printf("%s cost is %.2f %s", name, localPrice, currency))
			.join();
	}

	private static CompletableFuture<Product> getProductCF(String name) throws InterruptedException, ExecutionException{
		return CompletableFuture.supplyAsync(() -> catalogue.getProductByName(name));
	}
	
	private static CompletableFuture<Double> getPriceCF(Product product){
		return CompletableFuture.supplyAsync(() -> priceFinder.getPrice(product));
	}
	
	private static CompletableFuture<Double> getExchangeService(String currency){
		return CompletableFuture.supplyAsync(() -> exchangeService.getExchangeRate( currency));
	}
	
	private static double getTotalPrice(double price, double exchangeRate)
    {
        return price * exchangeRate;
    }
}
