package controller;

import model.*;
import java.util.ArrayList;

public class Controller {

    // Costruttore
    public Controller() {
        listaLezioni = new ArrayList<>();
        listaUtente = new ArrayList<>();
        listaInsegnamenti = new ArrayList<>();
        richieste = new ArrayList<>();
        listaAule = new ArrayList<>();
    }

    //Aula
    private ArrayList<Aula> listaAule = new ArrayList<>();
    public ArrayList<Aula> getAule() {
        return listaAule;
    }
    public void aggiungiAula(Aula a) {
        listaAule.add(a);
    }

    // LEZIONE
    private ArrayList<Lezione> listaLezioni = new ArrayList<>();

    public void aggiungiLezione(Lezione l) {
        listaLezioni.add(l);

    }

    public ArrayList<Lezione> getLezione() {
        return listaLezioni;
    }

    public void creaLezione(Insegnamento insegnamento, String giornoSettimana, String oraInizio, String oraFine, Aula aula) {
        Lezione l = new Lezione(insegnamento,giornoSettimana, oraInizio, oraFine,aula);
        listaLezioni.add(l);
    }


    //Docente
    public ArrayList<Docente> getDocenti() {
        ArrayList<Docente> docenti = new ArrayList<>();
        for(Utente u : listaUtente) {
            if(u instanceof Docente) {
                docenti.add((Docente) u);
            }
        }
        return docenti;
    }

    // UTENTE
    private ArrayList<Utente> listaUtente;

    public void aggiungiUtente(Utente u) {
        listaUtente.add(u);
    }

    public ArrayList<Utente> getUtente() {
        return listaUtente;
    }

    //LOGIN
    public Utente login(String login, String password) {
        for (Utente u : listaUtente) {
            if (u.getLogin().equals(login)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
    //CHECK LOGIN
    public boolean utenteEsistente(String login) {
        for (Utente u : listaUtente) {
            if (u.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
    //INSEGNAMENTI
    private ArrayList<Insegnamento> listaInsegnamenti;
    public void aggiungiInsegnamento(Insegnamento i) {
        this.listaInsegnamenti.add(i);
    }
    public ArrayList<Insegnamento> getInsegnamenti() {
        return listaInsegnamenti;
    }

    //Gestione Conflitti
    public boolean esisteConflitto(Lezione nuovaLezione) {

        for (Lezione l : listaLezioni) {

            // STESSO GIORNO
            if (l.getGiornoSettimana().equals(
                    nuovaLezione.getGiornoSettimana())) {

                // CONTROLLO SOVRAPPOSIZIONE ORARI
                boolean orarioConflitto =
                        nuovaLezione.getOraInizio()
                                .compareTo(l.getOraFine()) < 0

                                &&

                                nuovaLezione.getOraFine()
                                        .compareTo(l.getOraInizio()) > 0;

                // CONFLITTO AULA
                boolean stessaAula =
                        l.getAula().equals(
                                nuovaLezione.getAula());

                // CONFLITTO DOCENTE
                boolean stessoDocente =
                        l.getInsegnamento()
                                .getDocente()
                                .equals(

                                        nuovaLezione
                                                .getInsegnamento()
                                                .getDocente()
                                );

                if (orarioConflitto
                        &&
                        (stessaAula || stessoDocente)) {

                    return true;
                }
            }
        }

        return false;
    }
    private ArrayList<RichiestaSpostamento> richieste = new ArrayList<>();

    public void aggiungiRichiesta(RichiestaSpostamento r) {
        richieste.add(r);
    }

    public ArrayList<RichiestaSpostamento> getRichieste() {
        return richieste;
    }

    public void approvaRichiesta(RichiestaSpostamento r) {
        Lezione l = r.getLezione();

        Lezione prova = new Lezione(
                l.getInsegnamento(),
                r.getNuovoGiorno(),
                r.getNuovaOraInizio(),
                r.getNuovaOraFine(),
                l.getAula()
        );

        // controllo conflitti
        if (esisteConflitto(prova)) {
            throw new IllegalArgumentException(
                    "Conflitto: spostamento non possibile"
            );
        }
        // applica modifica
        l.setgiornoSettimana(r.getNuovoGiorno());
        l.setOraInizio(r.getNuovaOraInizio());
        l.setOraFine(r.getNuovaOraFine());
        r.setApprovata(true);
    }
}



