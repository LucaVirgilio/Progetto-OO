package model;

import java.util.ArrayList;
import java.util.List;

public class Utente {
    private String password;
    private String nomeUtente;


        this.password = password;
        this.nomeUtente = nomeUtente;

    }


    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }


}
