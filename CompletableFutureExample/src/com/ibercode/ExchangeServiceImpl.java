package com.ibercode;

import com.ibercode.api.ExchangeService;

public class ExchangeServiceImpl implements ExchangeService {

	private double exchangeRate;

	@Override
	public double getExchangeRate(String currency) {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switch (currency) {
		case "EUR":
			exchangeRate = 0.85;
			break;
		case "GBP":
			exchangeRate = 0.75;
			break;
		case "JPY":
			exchangeRate = 112.39;
			break;
		case "INR":
			exchangeRate = 68.62;
			break;
		case "RON":
			exchangeRate = 3.98;
			break;

		default:
			exchangeRate = 1;
			break;
		}

		return exchangeRate;
	}

}
