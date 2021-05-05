package se.kth.iv1350.POS.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import se.kth.iv1350.POS.controller.*;
import se.kth.iv1350.POS.DTOs.*;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.*;
class ControllerTest {
	private Controller instanceCont;
	private Sale newSale;
	
	@BeforeEach
	public void setUp() {
		RegistryCreator regCreator = new RegistryCreator();
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister(); 
		this.instanceCont = new Controller(regCreator, extSys, cashRegister);
		this.newSale = instanceCont.newSale();
	}
	
	@AfterEach
	public void tearDown(){
		instanceCont = null;
		newSale = null;
	}
	
	@Test
	void testNewSale() {
		assertNotNull(newSale, "New sale was not started");
	}

	@Test
	void testaddItem() {
		assertNotNull(newSale);
		assertEquals(1,instanceCont.addItem("asdf1234", 1).getItemInfo().size());
		assertEquals(2,instanceCont.addItem("asdf1234", 1).getItemInfo().size());
	}
	
 @Test
 void testDiscountRequest() {
	 
	 instanceCont.addItem("asdf1234", 1);
	 //assertEquals(1,instanceCont.addItem("asdf1234", 1).getItemInfo().size());
	 assertEquals(11,instanceCont.discountRequest("123ABC").getAmount());
 }
	
 @Test
 void testPay() {
	 
	 assertNotNull(newSale);
	 instanceCont.addItem("asdf1234", 4);
	 assertEquals(35,instanceCont.discountRequest("123ABC").getAmount());
	 assertEquals(35, newSale.getTotalPriceafterDiscount());
	 assertEquals(165,instanceCont.pay(new Amount(200, "SEK")).getAmount());
 
	
	
 }
	
	
	
	

}
