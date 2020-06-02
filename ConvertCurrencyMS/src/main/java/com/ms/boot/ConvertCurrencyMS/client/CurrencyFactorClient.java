package com.ms.boot.ConvertCurrencyMS.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="conversionfactor", fallback=CurrencyFactorFallback.class)
public interface CurrencyFactorClient {
	@GetMapping("/conversionfactor/{ctryCode}")
	Double getConversionFactor(@PathVariable String ctryCode);

}
