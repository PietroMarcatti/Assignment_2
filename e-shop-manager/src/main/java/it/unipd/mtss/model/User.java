////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.util.Calendar;

public interface User {

    Long getId();

    String getName();

    Calendar getDataNascita();

}