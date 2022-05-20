////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.util.Calendar;

public class RealUser implements User {

    private Long id;

    private String name;

    private Calendar dataNascita;

    public RealUser(Long id, String name, Calendar dataNascita) {
        if(id == null) {
            throw new IllegalArgumentException("id nullo");
        }
        if(name == null) {
            throw new IllegalArgumentException("Nome nullo non valido");
        }
        if(dataNascita == null) {
            throw new IllegalArgumentException("Data nulla non valida");
        }
        this.id = id;
        this.name = name;
        this.dataNascita = dataNascita;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Calendar getDataNascita() {
        return dataNascita;
    }

}
