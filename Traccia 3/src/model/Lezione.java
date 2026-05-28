package model;

import java.util.ArrayList;
import java.util.function.DoubleConsumer;

public class Lezione {
    protected Insegnamento insegnamento;
    protected String giornoSettimana;
    protected String oraInizio;
    protected String oraFine;
    protected Aula aula;
    private boolean attivo;

    public Lezione(Insegnamento insegnamento, String giornoSettimana, String oraInizio, String oraFine,Aula aula) {
        this.giornoSettimana = giornoSettimana;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.aula = aula;
        this.insegnamento = insegnamento;
        this.attivo = true;
    }
    public Aula getAula() {
        return aula;
    }
    public String getGiornoSettimana(){return giornoSettimana;}
    public String getOraInizio(){return oraInizio;}
    public String getOraFine(){return oraFine;}
    public Insegnamento getInsegnamento() {
        return insegnamento;
    }
    public boolean isAttivo() {
        return attivo;
    }
    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
    public void setgiornoSettimana(String giornoSettimana) {
        this.giornoSettimana = giornoSettimana;
    }
    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }
    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }
}