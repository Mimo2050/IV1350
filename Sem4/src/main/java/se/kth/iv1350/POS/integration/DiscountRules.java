package se.kth.iv1350.POS.integration;
import se.kth.iv1350.POS.DTOs.*;

import java.util.List;
import se.kth.iv1350.POS.model.Amount;
/**
*
* @author Abdullah
* Den här klassen ansvarar för rabattregler
*/
public class DiscountRules {
    private final int ITEMQUANTETYFORDISCOUNT = 4;
    private final double FIVEPROCENTDISCOUNT = 0.05;
    private final double TENPROCENTDISCOUNT = 0.1;
    private final double TWENTYPROCENTDISOCUNT = 0.2;
    private final double THIRTYROCENTDISOCUNT = 0.3;


    /**
     * Räknar upp antalet tillgängliga rabatter för medlemmar
     * @param saleInfo innehåller informatioen om försäljningen
     * @return returnerar rabatten i form av double-datatyp och innehåller rabatten i procent
     */
    public double discountRateMember(SaleDTO saleInfo ){
        double discount = 0.0;
        Amount totalAmount = saleInfo.getRunningTotal();
        int totalPrice = totalAmount.getAmount();
        List<ItemDTO> itemInfo = saleInfo.getItemInfo();

        if(totalPrice >= 100){
            discount = discount + TENPROCENTDISCOUNT;
        }
        if(isItemMilk (itemInfo)){
            discount = discount + TWENTYPROCENTDISOCUNT;
        }
        if(isQuantityMorethenfour(itemInfo)){
            discount = discount + THIRTYROCENTDISOCUNT;
        }
        return discount;
    }
    /**
     *  Counts the sum of the available discounts for non members
     * @param saleInfo holds the information of the sale
     * @return the discount of the data-type double and contains the percentage for discount
     */
    public  double discountRateNotMember(SaleDTO saleInfo){
        double discount = 0.0;
        Amount totalAmount = saleInfo.getRunningTotal();
        List<ItemDTO> itemInfo = saleInfo.getItemInfo();
        int totalPrice = totalAmount.getAmount();
        if(totalPrice >= 50){
            discount = discount + FIVEPROCENTDISCOUNT;
        }
        if(isItemMilk(itemInfo)){
            discount = discount + TENPROCENTDISCOUNT;
        }
        if(isQuantityMorethenfour(itemInfo)){
            discount = discount + TWENTYPROCENTDISOCUNT;
        }
        return discount;
    }

    private boolean isItemMilk (List<ItemDTO> itemInfo) {
        boolean isMilk = false;
        for (ItemDTO item : itemInfo) {

            if (item.getName() == "Milk") {
                isMilk = true;
                break;
            }
        }
        return isMilk;
    }




    private boolean isQuantityMorethenfour (List<ItemDTO> itemInfo){
        int totalQuantity = 0;

        for (ItemDTO item: itemInfo){
        	totalQuantity += item.getItemQuantity();
        }
        return totalQuantity >= ITEMQUANTETYFORDISCOUNT;
    }
}
