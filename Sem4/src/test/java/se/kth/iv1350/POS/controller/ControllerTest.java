package se.kth.iv1350.POS.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.POS.integration.ExternalSystemGenerator;
import se.kth.iv1350.POS.integration.RegistryCreator;
import se.kth.iv1350.POS.model.Amount;
import se.kth.iv1350.POS.model.CashRegister;
import se.kth.iv1350.POS.model.Sale;
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
	 void testPay() {
		String Juice = "asdf1234";
		int itemQuantity = 3;
		 
		try {
			instanceCont.addItem(Juice, itemQuantity);
			
			}
			catch (InvalidItemIdentifierException ex ) {
				fail("Got InvalidItemIdentifierException.");
				ex.printStackTrace();
			}
			catch (OperationFaliureException ex) {
				fail("Got OperationFaliureException.");
				ex.printStackTrace();
			}
			instanceCont.discountRequest("NON_MEMBER_CUSTOMER");
			Amount result = instanceCont.pay(new Amount(103,"kr"));
			
			assertEquals(70, result.getAmount(),"Should give customer discount and change should be correct." );

		
	 }
	

 @Test
	void testaddItem() {
		assertNotNull(newSale);
		try {
			assertEquals(1,instanceCont.addItem("asdf1234", 1).getItemInfo().size());
			assertEquals(2,instanceCont.addItem("asdf1234", 1).getItemInfo().size());
			fail("an item with wrong id was added");
		} catch (InvalidItemIdentifierException | OperationFaliureException e) {
			e.printStackTrace();
		}
		
	}
	
 @Test
	void testAddInvalidItem() throws OperationFaliureException {
		String invalidId = "wrongId";
		int itemQuantity = 2;
		try {
			instanceCont.addItem(invalidId, itemQuantity);
			fail("failed to add item because of an operation failuer");
		}catch(InvalidItemIdentifierException exc) {
			assertTrue(exc.getMessage().contains(invalidId), "wrong exception message");
		}
	}
 
 
 
 
 @Test
 void testDiscountRequest() {
	 
	 try {
		instanceCont.addItem("asdf1234", 1);
		 fail("an item with wrong id was added");
	} catch (InvalidItemIdentifierException | OperationFaliureException e) {

		e.printStackTrace();
	}

	 assertEquals(11,instanceCont.discountRequest("123ABC").getAmount());
 }

	
	
	
	

}
