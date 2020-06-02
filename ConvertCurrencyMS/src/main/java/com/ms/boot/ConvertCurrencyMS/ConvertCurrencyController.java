package com.ms.boot.ConvertCurrencyMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.boot.ConvertCurrencyMS.client.CurrencyFactorClient;
import com.ms.boot.ConvertCurrencyMS.service.ConvertCurrencyService;

@RestController
public class ConvertCurrencyController {

	@Autowired
	CurrencyFactorClient client;
	@Autowired
	ConvertCurrencyService service;

	

	@GetMapping("/convertCurrency/v1/{ctryCode}/{amount}")
	public Double getCurrencyCovert(@PathVariable String ctryCode, @PathVariable Double amount) {
		System.out.println("CLIENT---->"+client);
		Double convFactor = client.getConversionFactor(ctryCode);
		Double convertedAmt = null;
		if (amount != null && convFactor != null) {
			convertedAmt = convFactor * amount;
		} else {
			convertedAmt = new Double("0.0");
		}
		return convertedAmt;

	}
	
	@GetMapping("/convertCurrency/v2/{ctryCode}/{amount}")
	public Double getCurrencyCovertLoadBalanced(@PathVariable String ctryCode, @PathVariable Double amount) {
		
		Double convFactor = service.getCurrencyCovert(ctryCode);
		Double convertedAmt = null;
		if (amount != null && convFactor != null) {
			convertedAmt = convFactor * amount;
		} else {
			convertedAmt = new Double("0.0");
		}
		return convertedAmt;

	}
	
	
}
