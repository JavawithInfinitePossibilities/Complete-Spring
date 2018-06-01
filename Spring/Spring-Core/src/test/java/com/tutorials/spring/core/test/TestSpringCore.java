/**
 * 
 */
package com.tutorials.spring.core.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.spring.core.bean.impl.BikeInsurance;
import com.tutorials.spring.core.bean.impl.CarInsurance;
import com.tutorials.spring.core.bean.impl.OffersIndia;
import com.tutorials.spring.core.bean.intf.IOffers;
import com.tutorials.spring.core.bean.intf.Insurance;

/**
 * @author Siddhant sahu
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:/Spring-Config.xml")
public class TestSpringCore {

	@Autowired
	private ApplicationContext context;

	/*private ClassPathXmlApplicationContext context;*/

	// @Before
	public void init() {
		/*This can be used as a part of Junit tutorials.*/
		context = new ClassPathXmlApplicationContext("classpath*:/Spring-Config.xml");
		/*context = new FileSystemXmlApplicationContext("/src/main/resources/Spring-Config.xml");*/
	}

	@Test
	public void testSpringBean() {
		Insurance carInsurance = context.getBean("carInsurance", CarInsurance.class);
		System.out.println(carInsurance.showStatus());
		Insurance bikeInsurance = context.getBean("bikeInsurance", BikeInsurance.class);
		System.out.println(bikeInsurance.showStatus());
		OffersIndia offers = context.getBean("offersIndia", OffersIndia.class);
		offers.setOfferValue("Get 10% discount on next purchase...");
		System.out.println("--------------------------------------------------");
		System.out.println(carInsurance.showStatus());
		System.out.println(bikeInsurance.showStatus());
		// context.close();
	}
}
