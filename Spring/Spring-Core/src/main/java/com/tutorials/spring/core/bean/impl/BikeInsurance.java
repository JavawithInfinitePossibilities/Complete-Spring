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
public class BikeInsurance implements Insurance {

	@Value("2020")
	private int validation;

	@Autowired(required = false)
	@Qualifier("offersIndia")
	private IOffers currentOffer;

	public int getValidation() {
		return validation;
	}

	public void setValidation(int validation) {
		this.validation = validation;
	}

	public IOffers getCurrentOffer() {
		return currentOffer;
	}

	public void setCurrentOffer(IOffers currentOffer) {
		this.currentOffer = currentOffer;
	}

	/* (non-Javadoc)
	 * @see com.tutorials.spring.core.bean.intf.Insurance#showStatus()
	 */
	@Override
	public String showStatus() {
		return "Your bike is insured and your validation is " + this.getValidation() + " and "
				+ this.currentOffer.getOffer();
	}

}
