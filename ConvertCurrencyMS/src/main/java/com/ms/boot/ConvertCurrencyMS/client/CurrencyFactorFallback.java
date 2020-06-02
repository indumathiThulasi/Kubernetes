package com.ms.boot.ConvertCurrencyMS.client;

import org.springframework.stereotype.Component;

@Component
public class CurrencyFactorFallback  implements CurrencyFactorClient{

	@Override
	public Double getConversionFactor(String ctryCode) {
		System.out.println("Calling callback method");
		return new Double("0.0");
	}

}
