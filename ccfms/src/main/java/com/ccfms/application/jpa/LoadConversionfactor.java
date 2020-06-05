package com.ccfms.application.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ccfms.application.pojo.ConversionFactor;

@Configuration
public class LoadConversionfactor {
	@Bean
	CommandLineRunner initDatabase(ConversionFactorRepository repo) {
		return args->{	
			System.out.println("Preloading "+repo.save(new ConversionFactor("SG",new Double("50.0"))));
			System.out.println("Preloading "+repo.save(new ConversionFactor("UK",new Double("100.0"))));
			System.out.println("Preloading "+repo.save(new ConversionFactor("ASD",new Double("49.60"))));
			System.out.println("Preloading "+repo.save(new ConversionFactor("EUR",new Double("83.0"))));
			System.out.println("Preloading "+repo.save(new ConversionFactor("CND",new Double("54.3"))));
			System.out.println("Preloading "+repo.save(new ConversionFactor("USD",new Double("75.3"))));
			System.out.println("Preloading "+repo.save(new ConversionFactor("SWF",new Double("78.1"))));
		};
		
	}

}
