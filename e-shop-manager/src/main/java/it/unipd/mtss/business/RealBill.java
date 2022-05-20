////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.List;
import java.util.Calendar;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

public class RealBill implements Bill {
    /*
     * (non-Javadoc)
     * 
     * @see com.clarity.model.ClientBO#getClientProductsSum(java.util.List)
     */
    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user, 
        Calendar time) throws BillException {
        int[] numeroItem = new int[4];
        double prezzoTotaleProvvisorio = 0;
        
        for (EItem item : itemsOrdered){
            switch(item.getEItemType()){
                case MOTHERBOARD: numeroItem[0]+=1;break;
                case PROCESSOR: numeroItem[1]+=1;break;
                case MOUSE: numeroItem[2]+=1;break;
                case KEYBOARD: numeroItem[3]+=1;break;
                default: break;
            }
            prezzoTotaleProvvisorio+=item.getPrice();
        }

        return prezzoTotaleProvvisorio;
    }

}