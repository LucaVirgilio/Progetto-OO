package model;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ToDo {
    private String titolo;
    private String descrizione;
    private String url;
    private String link;
    private String immagine;
    private LocalDate dataScadenza;
    private StatoToDo stato;
    private Utente idAutore;

    private Color coloreSfondo;

    public ToDo (String titolo, String descrizione, String url, String link, String immagine, LocalDate dataScadenza, StatoToDo stato, Utente idAutore) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.url = url;
        this.link = link;
        this.immagine = immagine;
        this.dataScadenza = dataScadenza;
        this.stato = stato;
        this.idAutore = idAutore;


    }


        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public StatoToDo getStato() {
        return stato;
    }

    public void setStato(StatoToDo stato) {
        this.stato = stato;
    }

    public Utente getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Utente idAutore) {
        this.idAutore = idAutore;

    }

    }


    }


}