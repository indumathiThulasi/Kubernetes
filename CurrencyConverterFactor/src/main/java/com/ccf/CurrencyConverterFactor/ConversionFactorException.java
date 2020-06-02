package com.ccf.CurrencyConverterFactor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Failure")
public class ConversionFactorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConversionFactorException(String ctryCode) {
		super("Save is not successful for the country Code"+ctryCode);
		
	}

}
