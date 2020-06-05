package com.ccfms.application.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccfms.application.pojo.ConversionFactor;

public interface ConversionFactorRepository extends JpaRepository<ConversionFactor,String>{

}
