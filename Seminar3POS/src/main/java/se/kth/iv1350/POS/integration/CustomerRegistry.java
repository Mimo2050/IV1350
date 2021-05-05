package se.kth.iv1350.POS.integration;
import se.kth.iv1350.POS.DTOs.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerRegistry {
        private List<CustomerDTO> RegisterdCustomer = new ArrayList<>();
        private static final String CustomerID1 = "ASD123";
        private static final String CustomerID2 = "ZXC456";
        private static final String CustomerID3 = "ZAQ123";

        /**
         * Skapar en instans av CustomerRegistry
         */
        public CustomerRegistry(){
            addCustomer();
        }

        /**
         * kollar upp om kundens ID är lagrat i databasen
         * @param customerID  identifierar en kund
         * @return True om det finns i databasen , False om inte...
         */
        public boolean isEligible(String customerID) {
        	boolean isCustomer = false;
            for (CustomerDTO customer : RegisterdCustomer) {
                if (customer.getCustomerID().equals(customerID)) {
                   isCustomer = true;
                   break;
                }          
                 
           }
            return isCustomer;
            
        }

        private void addCustomer() {
            RegisterdCustomer.add(new CustomerDTO("Gustav",CustomerID1));
            RegisterdCustomer.add(new CustomerDTO("Anders",CustomerID2));
            RegisterdCustomer.add(new CustomerDTO("Bashar",CustomerID3));
        }
    }

