package com.ccfms.application.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ConversionFactor {
	
private @Id String ctryCode;
private Double convFactor;
public ConversionFactor(String ctryCode, Double convFactor) {
	this.ctryCode = ctryCode;
	this.convFactor = convFactor;
}
public ConversionFactor() {
}
public String getCtryCode() {
	return ctryCode;
}
public void setCtryCode(String ctryCode) {
	this.ctryCode = ctryCode;
}
public Double getConvFactor() {
	return convFactor;
}
public void setConvFactor(Double convFactor) {
	this.convFactor = convFactor;
}

}
