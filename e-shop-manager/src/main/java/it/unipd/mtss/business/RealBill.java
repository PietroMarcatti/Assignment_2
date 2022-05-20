////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.List;
import java.util.Random;
import java.time.Duration;
import java.util.Calendar;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItemType;
import it.unipd.mtss.model.User;

public class RealBill implements Bill {
    private int ordiniRegalati =0;
    private long[] idUtenti = new long[10];
    private Random rand = new Random();
    /*
     * (non-Javadoc)
     * 
     * @see com.clarity.model.ClientBO#getClientProductsSum(java.util.List)
     */
    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user, 
        Calendar time) throws BillException {
        int hours = time.get(Calendar.HOUR_OF_DAY);
        int[] numeroItem = new int[4];
        double prezzoTotaleProvvisorio = 0;
        rand.setSeed(0);
        
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

        if(numeroItem[1]>5){
            prezzoTotaleProvvisorio -= scontoProcessoreMenoCaro(itemsOrdered);
        }
        if(numeroItem[2]>10){
            prezzoTotaleProvvisorio -= regaloMouseMenoCaro(itemsOrdered);
        }
        if(numeroItem[2]>0 && numeroItem[2]==numeroItem[3]){
            prezzoTotaleProvvisorio -= 
            regaloMouseTastieraMenoCaro(itemsOrdered);
        }
        if(prezzoTotaleProvvisorio>1000){
            prezzoTotaleProvvisorio*=0.9;
        }
        if(itemsOrdered.size() > 30){
            throw new BillException("Ordine con più di 30 elementi");
        }
        if(prezzoTotaleProvvisorio<10){
            prezzoTotaleProvvisorio+=2;
        }
        if(hours >=18 && hours <=19 ){
            if(regaloPerMinorenne(user)){
                prezzoTotaleProvvisorio = 0;
            }
        }else{
            idUtenti = new long[10];
            ordiniRegalati = 0;
        }
        
        return prezzoTotaleProvvisorio;
    }

    private double scontoProcessoreMenoCaro(List<EItem> itemsOrdered){
        double prezzoMinore = Double.POSITIVE_INFINITY;
        for (EItem item : itemsOrdered){
            if(item.getEItemType()==EItemType.PROCESSOR
            && item.getPrice()<prezzoMinore){
                prezzoMinore = item.getPrice();
            }
        }
        return 0.5*prezzoMinore;
    }
    
    private double regaloMouseMenoCaro(List<EItem> itemsOrdered){
        double prezzoMinore = Double.POSITIVE_INFINITY;
        for (EItem item : itemsOrdered){
            if(item.getEItemType().toString().equals("MS") 
            && item.getPrice()<prezzoMinore){
                prezzoMinore = item.getPrice();
            }
        }
        return prezzoMinore;
    }

    private double regaloMouseTastieraMenoCaro(List<EItem> itemsOrdered){
        double prezzoMinore = Double.POSITIVE_INFINITY;
        for (EItem item : itemsOrdered){
            if((item.getEItemType() == EItemType.MOUSE 
            || item.getEItemType()== EItemType.KEYBOARD) 
            && item.getPrice()<prezzoMinore){
                prezzoMinore = item.getPrice();
            }
        }
        return prezzoMinore;
    }

    private Boolean regaloPerMinorenne(User user){
        
        Calendar now = Calendar.getInstance();
        long diff= Duration
        .between(user.getDataNascita().toInstant(), now.toInstant())
        .toDays()/365;
        int numero =rand.nextInt(2);
        if(ordiniRegalati < 10 && numero==1 && diff<18){
            Boolean trovato = false;
            for(long id : idUtenti){
                if(id == user.getId()){
                    trovato = true;
                } 
            }
            if(!trovato){
                idUtenti[ordiniRegalati] = user.getId();
                ordiniRegalati +=1;
                return true;
            }
            
        }
        return false;
    }

}