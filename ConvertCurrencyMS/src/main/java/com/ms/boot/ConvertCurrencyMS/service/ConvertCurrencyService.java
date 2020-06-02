package com.ms.boot.ConvertCurrencyMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@RibbonClient(name="conversionFactor")
public class ConvertCurrencyService {
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@HystrixCommand(fallbackMethod="conversionFactorFallBack")
	public Double getCurrencyCovert(String ctryCode){
	ServiceInstance instance=loadBalancerClient.choose("conversionFactor");
	String url="http://"+instance.getHost()+":"+instance.getPort()+"/conversionfactor/"+ctryCode;
	RestTemplate restTemplate=new RestTemplate();
	HttpEntity<String> entity=new HttpEntity<String>(ctryCode);
	ResponseEntity<Double> resEntity=restTemplate.exchange(url, HttpMethod.GET, entity, Double.class);
	Double convFactorRibbon=resEntity.getBody();
	System.out.println(url);
	return convFactorRibbon;
	}	
	
	public Double conversionFactorFallBack(String ctryCode) {
		return new Double("0.0");
	}
}
