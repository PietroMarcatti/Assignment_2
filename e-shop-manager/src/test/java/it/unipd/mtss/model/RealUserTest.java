////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;




public class RealUserTest {

    private Calendar date;
    private User user;

    @Before
    public void setup(){
        date= Calendar.getInstance();
        date.set(Calendar.YEAR,2000);
        user= new RealUser(new Long(1), "Davide", date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructonIdNull_throwsExceptions(){
        new RealUser(null, "Davide", date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructonNameNull_throwsExceptions(){
        new RealUser(new Long(1), null, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructonDateNull_throwsExceptions(){
        new RealUser(new Long(1), "Davide", null);
    }
    
    @Test
    public void user_getIdTest() {
        double expected = 1;
        double actual = user.getId();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void user_getNameTest() {
        String expected = "Davide";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void user_getDataNascitaTest() {
        Calendar expected= date;
        Calendar actual = user.getDataNascita();

        assertEquals(expected, actual);
    }
}
