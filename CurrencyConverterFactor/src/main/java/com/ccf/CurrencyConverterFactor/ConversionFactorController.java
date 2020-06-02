package com.ccf.CurrencyConverterFactor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionFactorController {

	private final ConversionFactorRepository repository;

	public ConversionFactorController(ConversionFactorRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/conversionfactor/{ctryCode}")
	public Double getConversionFactor(@PathVariable String ctryCode) {
		ConversionFactor factor= repository.findById(ctryCode)
			      .orElseThrow(() -> new NullPointerException("Get error "+ctryCode)) ;
		return factor.getConvFactor();
		
	}
	
	@PostMapping("/conversionfactor")
	@ResponseStatus(code=HttpStatus.OK,reason="Success")
	public void addConversionFactor(@RequestBody ConversionFactor factor) {
		try {
		repository.save(factor);
		}
		catch(Exception e){
			throw new ConversionFactorException(factor.getCtryCode());
		}
	}
	
	@PutMapping("/conversionfactor/{ctryCode}")
	@ResponseStatus(code=HttpStatus.OK,reason="Success")
	public void updateConversionFactor(@RequestBody ConversionFactor newFactor,@PathVariable String ctryCode) {
		try {
		
			ConversionFactor factor= repository.findById(ctryCode)
		      .orElseThrow(() -> new ConversionFactorException("Update error "+ctryCode)) ;
		  			factor.setCtryCode(newFactor.getCtryCode());
		  			factor.setConvFactor(newFactor.getConvFactor());
		  			repository.save(factor);
		  		
		        
		      }
		  

		
		catch(Exception e){
			throw new ConversionFactorException(ctryCode);
		}
	}
	
}
