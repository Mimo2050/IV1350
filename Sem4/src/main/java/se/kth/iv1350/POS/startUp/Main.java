package se.kth.iv1350.POS.startUp;
import java.io.IOException;


import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.CashRegister;
import se.kth.iv1350.POS.view.View;
/**
 * @author Abdullah
 *
 */
public class Main {

	/**
	 * @param args
	 * change the comment in main 
	 */
	public static void main(String[] args) {
		RegistryCreator regCreator = new RegistryCreator();
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister();
		Controller contr = new Controller(regCreator, extSys, cashRegister);
		try {
			View view = new View(contr);
			view.runFakeSale();
		}catch(IOException exc){
			exc.printStackTrace();
		}
	}
}