/**
 * 
 */
package com.tutorials.spring.core.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tutorials.spring.core.bean.intf.IOffers;
import com.tutorials.spring.core.bean.intf.Insurance;

/**
 * @author Siddhant sahu
 *
 */
@Component
public class CarInsurance implements Insurance {
	// @Value("sidhanth")
	private String name;
	// @Value("1000")
	private int insuranceId;

	private OffersUS offers;

	public CarInsurance() {
		super();
	}

	@Autowired(required = false)
	public CarInsurance(@Value("${US.name}") String name,
			@Value("${US.insuranceId}") int insuranceId, OffersUS offerUS) {
		super();
		this.name = name;
		this.insuranceId = insuranceId;
		this.offers = offerUS;
	}

	@Override
	public String showStatus() {
		return "Hi " + this.name + " your car is insured and insurance id is " + this.insuranceId
				+ " and " + this.offers.getOffer();
	}

}
