////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RealEItemTest {

    private EItemType type;
    private EItem item;

    @Before
    public void setup(){
        type = EItemType.KEYBOARD;
        item = new RealEItem("Tastiera Bella", type, 13.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructonNameNull_throwsExceptions(){
        new RealEItem(null, type, new Double(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructonTypeNull_throwsExceptions(){
        new RealEItem("Tastiera Bella", null, new Double(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructonPriceNull_throwsExceptions(){
        new RealEItem("Tastiera Bella", type, null);
    }
    
    @Test
    public void eitem_getEItemTypeTest() {
        EItemType expected = EItemType.KEYBOARD;
        EItemType actual = item.getEItemType();

        assertEquals(expected, actual);
    }

    @Test
    public void eitem_getNameTest() {
        String expected = "Tastiera Bella";
        String actual = item.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void eitem_getPriceTest() {
        double expected = 13.3;
        double actual = item.getPrice();

        assertEquals(expected, actual, 0.001);
    }
}
